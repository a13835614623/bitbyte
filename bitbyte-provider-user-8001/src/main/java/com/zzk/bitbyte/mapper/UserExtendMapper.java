package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.query.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户扩展类mapper
 *
 * @author zzk
 */
@Mapper
public interface UserExtendMapper {

    /**
     * 根据用户手机号或者邮箱获取用户信息
     * @param mobileOrEmail
     */
    User getUserByUserMobileOrEmail(String mobileOrEmail);

    /**
     * 用户信息综合查询
     *
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    List<User> findUsersByQueryVo(UserQueryVo userQueryVo);

    /**
     * 根据QueryVo信息综合查询数量
     *
     * @param vo
     * @return
     * @throws Exception
     */
    Integer findUsersCountByQueryVo(UserQueryVo vo);


    /**
     * 更新用户
     *
     * @param user
     * @throws Exception
     */
    void updateUser(User user);

    /**
     * 得到关注列表
     *
     * @param userId 操作用户的id
     * @return 关注用户列表
     * @throws Exception
     */
    List<User> findSubscribersByUserId(@Param("userId") String userId,
                                              @Param("start") Integer start,
                                              @Param("count") Integer count);

    /**
     * 通过用户id查找粉丝
     *
     * @param userId 用户id
     * @throws Exception
     */
    List<User> findFansByUserId(@Param("userId") String userId,
                                       @Param("start") Integer start,
                                       @Param("count") Integer count);

    /**
     * 通过用户id查找粉丝数量
     * @param userId
     * @return
     */
    long findFansCountByUserId(String userId);

    /**
     * 通过用户id查找关注者数量
     * @param userId
     * @return
     */
    long findSubscriberCountByUserId(String userId);
}
