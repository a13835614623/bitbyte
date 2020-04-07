package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.query.UserQueryVo;

import java.util.List;

/**
 * 用户接口
 *
 * @author zzk
 */
public interface UserService {

    String USER="用户";
    String USER_ID=USER+"ID";

    /**
     * 添加用户
     *
     * @param user
     * @
     */
    User addUser(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @
     */
    void deleteByUserId(String userId) throws Exception;

    /**
     * 更新用户
     *
     * @param user
     * @
     */
    void updateUser(User user) throws Exception;

    /**
     * 通过id查询用户
     *
     * @param userId 用户id
     * @
     */
    User findUserById(String userId) throws Exception;

    /**
     * 根据QueryVo信息综合查询
     *
     * @param vo
     * @return
     * @
     */
    List<User> findUserListByQueryVo(UserQueryVo vo) throws Exception;

    /**
     * 根据QueryVo信息综合查询数量
     *
     * @param vo
     * @return
     * @
     */
    Integer findUsersCountByQueryVo(UserQueryVo vo) throws Exception;

    /**
     * 得到关注列表
     *
     * @param userId 操作用户的id
     * @return 关注用户列表
     * @
     */
    List<User> findSubscribersById(String userId) throws Exception;


    /**
     * 通过用户id查找粉丝
     *
     * @param userId 用户id
     * @
     */
    List<User> findFansByUserId(String userId) throws Exception;
}
