package com.zzk.bitbyte.cache;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户认证缓存管理
 * @Author: zzk
 * @Date: 2020-03-09 11:18
 */
@Component
public class UserAuthCacheManager {
    private static final String KEY_AUTH_PRE = "bitbyte:auth:";

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;
    /**
     * 删除用户认证缓存
     *
     * @param userId
     */
    public void deleteAuthInfoCache(String userId) throws Exception {
        User user = userService.findUserById(userId);
        redisUtil.del(KEY_AUTH_PRE + user.getUserMobile());
        redisUtil.del(KEY_AUTH_PRE + user.getUserEmail());
    }
}
