package com.zzk.bitbyte.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzk.bitbyte.mapper.UserExtendMapper;
import com.zzk.bitbyte.mapper.UserMapper;
import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.query.UserQueryVo;
import com.zzk.bitbyte.service.UserService;
import com.zzk.bitbyte.util.RedisUtil;
import com.zzk.bitbyte.util.UserState;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final String KEY_USER_PRE = "bitbyte:user:";
    private static final String KEY_USER_FANS_PRE = "bitbyte:user:fans:";
    private static final String KEY_USER_SUBS_PRE = "bitbyte:user:subs:";

    @Autowired
    private UserExtendMapper userExtendMapper;

    @Autowired
    private UserMapper usermapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User addUser(User user) throws Exception {
        try {
            Util.validateObj(user, USER);
            user.setUserId(UUID.randomUUID().toString());
            Date date = new Date();
            user.setCreateat(date);
            user.setUpdateat(date);
            user.setUserState(UserState.NORMAL.getValueId());
            usermapper.insert(user);
        } catch (Exception e) {
            throw new Exception("手机号/邮箱已被注册!");
        }
        return user;
    }

    @Override
    public void deleteByUserId(String userId) throws Exception {
        Util.validateObj(userId, USER_ID);
        User user = new User();
        user.setUserId(userId);
        user.setUserState(UserState.DELETED.getValueId());
        usermapper.updateByPrimaryKeySelective(user);
        // 删除信息缓存
        redisUtil.del(KEY_USER_PRE + userId);
    }

    @Override
    public void updateUser(User user) throws Exception {
        Util.validateObj(user, USER);
        String userId = user.getUserId();
        Util.validateStr(userId, "用户id");
        try {
            userExtendMapper.updateUser(user);
        }catch (Exception e){
            throw new Exception("更新失败!");
        }
        // 删除信息缓存
        redisUtil.del(KEY_USER_PRE + userId);
    }

    public static User map2User(Map<Object, Object> map) {
        User user = new User();
        user.setUserId((String) map.get("userId"));
        user.setUserName((String) map.get("userName"));
        user.setUserBirthday(long2Date(map.get("userBirthday")));
        user.setUserPassword((String) map.get("userPassword"));
        user.setUserEmail((String) map.get("userEmail"));
        user.setUserMobile((String) map.get("userMobile"));
        user.setUserPic((String) map.get("userPic"));
        //int
        user.setUserState(Integer.parseInt((String) map.get("userState")));
        user.setUserAddress((String) map.get("userAddress"));
        user.setUserSex((String) map.get("userSex"));
        user.setCreateat(long2Date(map.get("createAt")));
        user.setUpdateat(long2Date(map.get("updateAt")));
        return user;
    }

    public static Date long2Date(Object o) {
        return o == null ? null : new Date(Long.parseLong((String) o));
    }

    public static Map<Object, Object> user2Map(User user) {
        Map<Object, Object> map = new HashMap<>();
        map.put("userId", user.getUserId());
        map.put("userName", user.getUserName());
        map.put("userPassword", user.getUserPassword());
        map.put("userEmail", user.getUserEmail());
        map.put("userMobile", user.getUserMobile());
        map.put("userPic", user.getUserPic());
        map.put("userState", user.getUserState() + "");
        map.put("userBirthday", user.getUserBirthday().getTime() + "");
        map.put("userAddress", user.getUserAddress());
        map.put("userSex", user.getUserSex());
        map.put("createAt", user.getCreateat().getTime() + "");
        map.put("updateAt", user.getUpdateat().getTime() + "");
        return map;
    }

    @Override
    public User findUserById(String userId) throws Exception {
        String key = KEY_USER_PRE + userId;
        Util.validateStr(userId, USER_ID);
        Map<Object, Object> map = redisUtil.hmget(key);
        User user;
        if (map.size() > 0) {
            user = map2User(map);
        } else {
            user = usermapper.selectByPrimaryKey(userId);
            redisUtil.hmset(KEY_USER_PRE + userId, user2Map(user), Util.randomExpTime(1));
        }
        user.setUserPassword(null);
        return user;
    }

    @Override
    public List<User> findUserListByQueryVo(UserQueryVo vo) throws Exception {
        Util.validateQueryVo(vo);
        return userExtendMapper.findUsersByQueryVo(vo);
    }

    @Override
    public Integer findUsersCountByQueryVo(UserQueryVo vo) throws Exception {
        Util.validateQueryVo(vo);
        return userExtendMapper.findUsersCountByQueryVo(vo);
    }

    private void validate(String userId, Integer start, Integer count) throws Exception {
        Util.validateStr(userId, "用户ID");
        Util.validateObj(start, "开始索引不能为空!");
        Util.validateObj(count, "数量不能为空!");
    }

    @Override
    public List<User> findSubscribersById(String userId, Integer start, Integer count) throws Exception {
        validate(userId, start, count);
        start = Math.max(start, 0);
        count = Math.min(count, 10);
        return userExtendMapper.findSubscribersByUserId(userId, start, count);
    }

    public Object[] userList2Array(List<User> users) {
        int len = users.size();
        String[] userStrs = new String[len];
        for (int i = 0; i < len; i++) {
            try {
                userStrs[i] = Util.bean2Json(users.get(i));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return userStrs;
    }


    @Override
    public List<User> findFansByUserId(String userId, Integer start, Integer count) throws Exception {
        validate(userId, start, count);
        start = Math.max(start, 0);
        count = Math.min(count, 10);
        return userExtendMapper.findFansByUserId(userId, start, count);
    }

    @Override
    public long findFansCountByUserId(String userId) throws Exception {
        Util.validateStr(userId, "用户ID");
        return userExtendMapper.findFansCountByUserId(userId);
    }

    @Override
    public long findSubscriberCountByUserId(String userId) throws Exception {
        Util.validateStr(userId, "用户ID");
        return userExtendMapper.findSubscriberCountByUserId(userId);
    }
}
