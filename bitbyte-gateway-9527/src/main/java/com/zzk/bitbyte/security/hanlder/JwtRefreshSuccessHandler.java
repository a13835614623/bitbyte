package com.zzk.bitbyte.security.hanlder;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zzk.bitbyte.security.JwtAuthenticationToken;
import com.zzk.bitbyte.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 刷新token的处理
 */
@Component
public class JwtRefreshSuccessHandler implements ServerAuthenticationSuccessHandler {

    @Value("${jwt.token.refresh}")
    int tokenRefreshInterval;  //刷新间隔/s

    private UserService userService;

    public JwtRefreshSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        DecodedJWT decodedJWT = ((JwtAuthenticationToken) authentication).getDecodedJWT();
        boolean shouldRefresh = shouldTokenRefresh(decodedJWT.getIssuedAt());
        if (shouldRefresh) {
            try {
                String newToken = userService.createToken(userService.getUserAuthInfo(decodedJWT.getSubject()));
                exchange.getResponse().getHeaders().set(HttpHeaders.AUTHORIZATION, newToken);
            } catch (Exception e) {
                return Mono.error(e);
            }
        }
        return webFilterExchange.getChain().filter(exchange);
    }

    /**
     * 是否应该刷新
     *
     * @param issueAt
     * @return
     */
    protected boolean shouldTokenRefresh(Date issueAt) {
        LocalDateTime issueTime = LocalDateTime.ofInstant(issueAt.toInstant(), ZoneId.systemDefault());
        return LocalDateTime.now().minusSeconds(tokenRefreshInterval).isAfter(issueTime);
    }

}
