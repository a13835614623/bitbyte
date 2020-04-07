package com.zzk.bitbyte.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.TokenUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

/**
 * @Author: zzk
 * @Date: 2020-02-24 22:39
 */
@Data
@AllArgsConstructor
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {

    private UserService userService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.isAuthenticated())return Mono.just(authentication);
        JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
        // 从请求中获取的解析后的token
        DecodedJWT jwt = ((JwtAuthenticationToken)authentication).getDecodedJWT();
        UserDetails userDetails;
        try {
            userDetails = userService.getUserAuthInfo(jwt.getSubject());
            if (userDetails==null){
                throw new BadCredentialsException("Token已失效!");
            }
            TokenUtil.validateToken(jwt,userDetails);
        } catch (TokenExpiredException e) {
            return Mono.error(new BadCredentialsException("Token已过期!", e));
        }catch (JWTVerificationException e){
            return Mono.error(new BadCredentialsException("Token验证失败!", e));
        }catch (BadCredentialsException e){
            return Mono.error(new BadCredentialsException(e.getMessage(), e));
        }
        authenticationToken.setUserDetails(userDetails);
        authenticationToken.setAuthorities(userDetails.getAuthorities());
        authenticationToken.setAuthenticated(true);
        return Mono.just(authenticationToken);
    }
}
