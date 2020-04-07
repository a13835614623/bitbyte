package com.zzk.bitbyte.security;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * @Author: zzk
 * @Date: 2020-02-23 12:17
 */
@Data
@AllArgsConstructor
public class MyUserDeatils implements UserDetails {
    private String password;
    private String username;
    private User user;
    private Set<SimpleGrantedAuthority> authorities;
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;
    private boolean enabled=true;
    public MyUserDeatils(String username, String password, Set<SimpleGrantedAuthority> authorities) throws Exception {
        super();
        Util.validateStr(username,"用户名");
        Util.validateStr(password,"密码");
        this.username=username;
        this.password=password;
        this.authorities= authorities;
    }

    @Override
    public Set<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
