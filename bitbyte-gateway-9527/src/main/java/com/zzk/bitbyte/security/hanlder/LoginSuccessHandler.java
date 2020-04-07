package com.zzk.bitbyte.security.hanlder;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.security.MyUserDeatils;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 登录成功
 */
@Component
public class LoginSuccessHandler extends WebFilterChainServerAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @SneakyThrows
    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
        MyUserDeatils userDetails = (MyUserDeatils) authenticationToken.getPrincipal();
        //生成token，并把token放入响应头
        try {
            String token = userService.createToken(userDetails);
            response.getHeaders().add(HttpHeaders.AUTHORIZATION, token);
            response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userDetails.getUser();
        UserData userData = new UserData();
        BeanUtils.copyProperties(user, userData);
        userData.setUserAuth(UserService.convertAuthSetToStr(userDetails.getAuthorities()));
        DataBuffer bodyDataBuffer = response.bufferFactory()
                .wrap(Util.bean2Json(ResponseState.success("登录成功!").setData(userData)).getBytes());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
    static class UserData extends User {
        private String userAuth;
        public UserData() {
        }
        public UserData(String userAuth) {
            this.userAuth = userAuth;
        }

        public String getUserAuth() {
            return userAuth;
        }

        public void setUserAuth(String userAuth) {
            this.userAuth = userAuth;
        }
    }
}
