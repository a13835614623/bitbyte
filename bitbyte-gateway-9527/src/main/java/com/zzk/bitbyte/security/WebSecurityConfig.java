package com.zzk.bitbyte.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zzk.bitbyte.security.hanlder.JwtRefreshSuccessHandler;
import com.zzk.bitbyte.security.hanlder.LoginFailHandler;
import com.zzk.bitbyte.security.hanlder.LoginSuccessHandler;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.Roles;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailHandler loginFailHandler;

    @Qualifier("tokenFailHandler")
    @Autowired
    LoginFailHandler tokenFailHandler;

    @Autowired
    JwtRefreshSuccessHandler jwtRefreshSuccessHandler;

    @Autowired
    UserService userService;

    public static final String LOGIN_URL = "/api/login";
    public static final String LOGOUT_URL = "/api/logout";
    public static final String LOGIN_USERNAME = "username";
    public static final String LOGIN_PASSWORD = "password";
    public static final String TOKEN_PARSE_FAILED = "Token解析失败!";

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) throws Exception {
        http.authorizeExchange()
                .pathMatchers("/api/admin/**").hasRole(Roles.ADMIN)
                .pathMatchers("/api/audit/**").hasRole(Roles.AUDITOR)
                .anyExchange().permitAll()
                .and()
                .csrf().disable()  //CRSF禁用，因为不使用session
                .cors() //支持跨域
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .addFilterAt(authenticationWebFilter(),
                        SecurityWebFiltersOrder.FORM_LOGIN)
                .addFilterAt(jwtAuthenticationWebFilter(), SecurityWebFiltersOrder.EXCEPTION_TRANSLATION);
        return http.build();
    }

    /**
     * 认证过滤器
     *
     * @return
     */
    @Bean
    AuthenticationWebFilter authenticationWebFilter() {
        AuthenticationWebFilter webFilter = new AuthenticationWebFilter(authenticationManager());
        webFilter.setServerAuthenticationConverter(exchange -> {
            Map<String, String> params = exchange.getRequest().getQueryParams().toSingleValueMap();
            String username = Optional.ofNullable(params.get(LOGIN_USERNAME)).orElseGet(() -> "");
            String password = Optional.ofNullable(params.get(LOGIN_PASSWORD)).orElseGet(() -> "");
            return Mono.just(new UsernamePasswordAuthenticationToken(username, password));
        });
        webFilter.setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.pathMatchers(LOGIN_URL));
        webFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        webFilter.setAuthenticationFailureHandler(loginFailHandler);
        return webFilter;
    }

    public static String getAuthorization(ServerHttpRequest request) {
        Map<String,String> httpHeaders = request.getHeaders().toSingleValueMap();
        String auth = httpHeaders.get(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotBlank(auth)){
            return auth;
        }
        return httpHeaders.get(HttpHeaders.AUTHORIZATION.toLowerCase());
    }

    /**
     * jwt认证过滤器
     *
     * @return
     */
    @Bean
    AuthenticationWebFilter jwtAuthenticationWebFilter() {
        AuthenticationWebFilter webFilter = new AuthenticationWebFilter(jwtAuthenticationManager());
        webFilter.setRequiresAuthenticationMatcher((exchange) -> {
            ServerHttpRequest request = exchange.getRequest();
            if (request.getURI().getPath().equals(LOGIN_URL)) {
                return ServerWebExchangeMatcher.MatchResult.notMatch();
            }
            if (StringUtils.isBlank(getAuthorization(request)))
                return ServerWebExchangeMatcher.MatchResult.notMatch();
            return ServerWebExchangeMatcher.MatchResult.match();
        });
        webFilter.setServerAuthenticationConverter(exchange -> {
            ServerHttpRequest request = exchange.getRequest();
            String token = getAuthorization(request);
            // 从请求中获取的解析后的token
            DecodedJWT jwt;
            try {
                jwt = JWT.decode(token);
            } catch (JWTDecodeException e) {
                return Mono.error(new BadCredentialsException(TOKEN_PARSE_FAILED, e));
            }
            return Mono.just(new JwtAuthenticationToken(jwt, null, null));
        });
        webFilter.setAuthenticationSuccessHandler(jwtRefreshSuccessHandler);
        webFilter.setAuthenticationFailureHandler(tokenFailHandler);
        return webFilter;
    }

    /**
     * 登录认证管理器
     *
     * @return
     */
    public ReactiveAuthenticationManager authenticationManager() {
        UserDetailsRepositoryReactiveAuthenticationManager manager = new UserDetailsRepositoryReactiveAuthenticationManager(userService);
        manager.setPasswordEncoder(passwordEncoder());
        return manager;
    }

    /**
     * jwt认证管理器
     *
     * @return
     */
    public ReactiveAuthenticationManager jwtAuthenticationManager() {
        JwtAuthenticationManager manager = new JwtAuthenticationManager(userService);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * token认证失败处理
     *
     * @return
     */
    @Bean("tokenFailHandler")
    public LoginFailHandler tokenFailHandler() {
        return new LoginFailHandler(LoginFailHandler.TOKEN_FAILED_MESSAGE);
    }

    /**
     * 登录失败处理
     *
     * @return
     */
    @Bean("loginFailHandler")
    public LoginFailHandler loginFailHandler() {
        return new LoginFailHandler(LoginFailHandler.LOGIN_FAILED_MESSAGE);
    }
}
