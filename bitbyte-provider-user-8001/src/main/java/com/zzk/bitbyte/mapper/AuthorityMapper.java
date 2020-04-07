package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-01-28 20:40
 */
@Mapper
public interface AuthorityMapper {
    /**
     * 根据用户id查询用户的角色
     * @param userId
     */
    List<Role> getRoleListByUserId(String userId);

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
    List<Permission> getPermissionListByUserId(String userId);

    /**
     * 根据角色id查询角色权限
     * @param roleId
     */
    List<Permission> getPermissionListByRoleId(String roleId);

    /**
     * 根据用户邮箱或者手机号获取角色
     * @param mobileOrEmail
     * @return
     */
    List<Role> getRoleListByUserMobileOrEmail(String mobileOrEmail);

    /**
     * 根据用户邮箱或者手机号获取角色
     * @param mobileOrEmail
     */
    List<Role> getPermissionListByUserMobileOrEmail(String mobileOrEmail);

}
