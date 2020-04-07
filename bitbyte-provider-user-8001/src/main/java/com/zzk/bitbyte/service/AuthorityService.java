package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.Role;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-01-28 19:55
 */
public interface AuthorityService {
    String USER_ID= "用户ID";
    String ROLE_ID = "角色ID";
    String PERM_ID = "权限ID";
    String MOBILE_OR_EMAIL= "用户手机号或者邮箱";

    /**
     * 根据用户id查询用户的角色
     *
     * @param userId
     */
    List<Role> getRoleListByUserId(String userId) throws Exception;

    /**
     * 根据用户id查询用户权限
     *
     * @param userId
     * @return
     */
    List<Permission> getPermissionListByUserId(String userId) throws Exception;

    /**
     * 根据角色id查询角色权限
     *
     * @param roleId
     */
    List<Permission> getPermissionListByRoleId( String roleId) throws Exception;


    /**
     * 根据用户邮箱或者手机号获取角色
     *
     * @param mobileOrEmail
     * @return
     */
    List<Role> getRoleListByUserMobileOrEmail( String mobileOrEmail) throws Exception;

    /**
     * 为用户添加角色
     * @param roleId
     * @param userId
     */
    void addRoleToUser(String roleId, String userId) throws Exception;

    /**
     * 为角色添加权限
     * @param permId
     * @param roleId
     */
    void addPermissionToRole(String permId, String roleId) throws Exception;

    /**
     * 为用户删除角色
     * @param roleId
     * @param userId
     */
    void deleteRoleFromUser(String roleId, String userId) throws Exception;

    /**
     * 为角色删除权限
     * @param permId
     * @param roleId
     */
    void deletePermissionFromRole(String permId, String roleId) throws Exception;

}
