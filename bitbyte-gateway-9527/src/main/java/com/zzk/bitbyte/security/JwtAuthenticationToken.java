package com.zzk.bitbyte.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author: zzk
 * @Date: 2020-02-22 21:20
 */
@Data
@NoArgsConstructor
public class JwtAuthenticationToken implements Authentication {
    public JwtAuthenticationToken(DecodedJWT decodedJWT) {
        this.decodedJWT = decodedJWT;
    }

    private DecodedJWT decodedJWT;
    private UserDetails userDetails;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean authenticated;
    public JwtAuthenticationToken(DecodedJWT decodedJWT, UserDetails userDetails, Collection<? extends GrantedAuthority> authorities) {
        this.decodedJWT = decodedJWT;
        this.userDetails = userDetails;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getCredentials() {
        return userDetails.getPassword();
    }

    @Override
    public UserDetails getDetails() {
        return userDetails;
    }

    @Override
    public String getPrincipal() {
        return userDetails.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated=b;
    }

    /**
     * Returns the name of this principal.
     *
     * @return the name of this principal.
     */
    @Override
    public String getName() {
        return getPrincipal();
    }

}
