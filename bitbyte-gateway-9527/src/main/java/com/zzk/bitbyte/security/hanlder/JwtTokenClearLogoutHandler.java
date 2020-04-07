package com.zzk.bitbyte.security.hanlder;

import com.zzk.bitbyte.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.ServerLogoutHandler;
import reactor.core.publisher.Mono;

/**
 * 清空token
 */
public class JwtTokenClearLogoutHandler implements ServerLogoutHandler {
    
    private UserService userService;
    
    public JwtTokenClearLogoutHandler(UserService userService) {
        this.userService = userService;
    }

    private void clearToken(Authentication authentication) {
        if(authentication == null)
            return;
        UserDetails user = (UserDetails)authentication.getDetails();
        if(user!=null && user.getUsername()!=null)
            userService.deleteUserAuthInfo(user.getUsername());
    }


    @Override
    public Mono<Void> logout(WebFilterExchange webFilterExchange, Authentication authentication) {
        clearToken(authentication);
        return Mono.empty();
    }
}
