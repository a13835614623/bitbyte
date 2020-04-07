package com.zzk.bitbyte.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Sets;
import com.zzk.bitbyte.mapper.UserMapper;
import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.extend.UserExtend;
import com.zzk.bitbyte.security.MyUserDeatils;
import com.zzk.bitbyte.util.RedisUtil;
import com.zzk.bitbyte.util.TokenUtil;
import com.zzk.bitbyte.util.Util;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Component
@Slf4j
public class UserService implements ReactiveUserDetailsService {

    @Value("${jwt.token.exp}")
    private long exp;
    public static final String KEY_AUTH_PRE = "bitbyte:auth:";
    public static final String AUTHORITIES_SPLIT = ",";
    public static final String KEY_ITEM_PASSWORD = "userPassword";
    public static final String KEY_ITEM_USER = "user";
    public static final String KEY_ITEM_AUTHORITIES = "authorities";

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails convert(UserExtend user, String username) {
        try {
            Util.validateObj(user, "用户信息");
            Set<SimpleGrantedAuthority> roles = user.getRoleList().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleStr()))
                    .collect(Collectors.toSet());
            Set<SimpleGrantedAuthority> perms = user.getPermList().stream().map(perm -> new SimpleGrantedAuthority(perm.getPermStr()))
                    .collect(Collectors.toSet());
            roles.addAll(perms);
            MyUserDeatils myUserDeatils = new MyUserDeatils(username, passwordEncoder.encode(user.getUserPassword()), roles);
            myUserDeatils.setUser(user);
            return myUserDeatils;
        } catch (Exception e) {
            log.error("转换失败！", e);
            return null;
        }
    }

    /**
     * 从缓存中读取用户信息
     *
     * @param username
     * @return
     */
    public UserDetails getUserAuthInfo(String username) {
        try {
            String key = KEY_AUTH_PRE + username;
            String password = (String) redisUtil.hget(key, KEY_ITEM_PASSWORD);
            Object authoritiesObj = redisUtil.hget(key, KEY_ITEM_AUTHORITIES);
            User user = Util.json2Bean((String) redisUtil.hget(key, KEY_ITEM_USER), User.class);
            Set<SimpleGrantedAuthority>
                    simpleGrantedAuthorities = null;
            if (authoritiesObj != null) {
                String authorities = (String) authoritiesObj;
                if (!Util.isEmpty(authorities)) {
                    simpleGrantedAuthorities = Sets
                            .newHashSet(authorities.split(AUTHORITIES_SPLIT)).stream()
                            .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
                }
            }
            MyUserDeatils myUserDeatils = new MyUserDeatils(username, password, simpleGrantedAuthorities);
            myUserDeatils.setUser(user);
            // 重置过期时间
            redisUtil.expire(key, Util.randomExpTime(1));
            return myUserDeatils;
        } catch (Exception e) {
            log.error("读取用户信息缓存失败！", e);
            return null;
        }
    }

    /**
     * 删除缓存的用户信息
     *
     * @param username
     */
    public void deleteUserAuthInfo(String username) {
        redisUtil.del(KEY_AUTH_PRE + username);
    }

    /**
     * 保存用户认证信息到缓存
     *
     * @param userDetails
     * @return
     */
    public void saveUserAuthInfo(MyUserDeatils userDetails) throws JsonProcessingException {
        String key = KEY_AUTH_PRE + userDetails.getUsername();
        Set<SimpleGrantedAuthority> authorities = userDetails.getAuthorities();
        String auth=convertAuthSetToStr(authorities);
        redisUtil.hset(key, KEY_ITEM_USER, Util.bean2Json(userDetails.getUser()));
        redisUtil.hset(key, KEY_ITEM_PASSWORD, userDetails.getPassword());
        redisUtil.hset(key, KEY_ITEM_AUTHORITIES, auth);
        // 过期时间一天+
        redisUtil.expire(key, Util.randomExpTime(1));
    }

    /**
     * 转换权限集合为字符串
     * @param authorities
     * @return
     */
    public static String convertAuthSetToStr(Set<SimpleGrantedAuthority> authorities) {
        if (authorities == null || authorities.size() == 0) return "";
        StringBuffer auth = new StringBuffer();
        authorities.forEach(authority -> {
            auth.append(authority.getAuthority()).append(AUTHORITIES_SPLIT);
        });
        if (auth.length() > 0) auth.deleteCharAt(auth.length() - 1);
        return auth.toString();
    }

    /**
     * 创建token
     *
     * @param userDetails
     * @return
     * @throws Exception
     */
    public String createToken(UserDetails userDetails) throws Exception {
        try {
            return TokenUtil.createToken(userDetails, exp);
        } catch (Exception e) {
            throw new Exception("TOKEN 创建失败！");
        }
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        UserDetails userDetails = getUserAuthInfo(username);
        if (userDetails == null) {
            try {
                UserExtend userExtend = userMapper.findUserByMobileOrEmail(username);
                userDetails = convert(userExtend, username);
                if (userDetails != null)//放入缓存
                    saveUserAuthInfo((MyUserDeatils) userDetails);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (userDetails==null){
            return Mono.error(new UsernameNotFoundException("该用户不存在！"));
        }else {
            return Mono.just(userDetails);
        }
    }
}
