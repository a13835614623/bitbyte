package com.zzk.bitbyte.interceptor;

import com.zzk.bitbyte.po.UserPrincipal;
import com.zzk.bitbyte.util.RedisUtil;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: zzk
 * @Date: 2020-02-20 11:09
 */
@Component
public class WebsocketManager {

    private static final String KEY_ONLINE = "bitbyte:user:online";

    @Autowired
    RedisUtil redis;

    /**
     * 添加在线用户
     *
     * @param user
     */
    void pushOnlineUser(UserPrincipal user) {
        if (user == null) return;
        redis.sSet(KEY_ONLINE, user.getUserId());
    }

    /**
     * 移除在线用户
     * @param userId
     */
    void removeOnlineUser(String userId) {
        redis.setRemove(KEY_ONLINE, userId);
    }

    /**
     * 是否在线
     * @param userId
     * @return
     */
    boolean isOnline(String userId) {
        if (Util.isEmpty(userId)) {
            return false;
        }
        return redis.sHasKey(KEY_ONLINE, userId);
    }
}
