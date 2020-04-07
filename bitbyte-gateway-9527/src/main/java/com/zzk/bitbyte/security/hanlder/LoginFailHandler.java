package com.zzk.bitbyte.security.hanlder;

import com.zzk.bitbyte.security.WebSecurityConfig;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
public class LoginFailHandler implements ServerAuthenticationFailureHandler {
    public static final String LOGIN_FAILED_MESSAGE = "登录失败！";
    public static final String TOKEN_FAILED_MESSAGE = "Token认证失败！";

    private String message;

    @SneakyThrows
    public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException e) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest request = exchange.getRequest();
        //设置headers
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        if(!request.getURI().getPath().contains(WebSecurityConfig.LOGIN_URL)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
        }
        String failedReason=e.getMessage();
        if (e instanceof UsernameNotFoundException){
            failedReason="用户不存在！";
        }else if (e instanceof BadCredentialsException){
            failedReason="密码错误！";
        }
        DataBuffer bodyDataBuffer = response.bufferFactory()
                .wrap(Util.bean2Json(ResponseState.error(message+failedReason).setData(failedReason)).getBytes());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
}
