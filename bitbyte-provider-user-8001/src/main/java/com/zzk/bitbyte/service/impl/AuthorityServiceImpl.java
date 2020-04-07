package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.*;
import com.zzk.bitbyte.po.*;
import com.zzk.bitbyte.service.AuthorityService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-01-28 19:55
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    /**
     * 根据用户id查询用户的角色
     *
     * @param userId
     */
    @Override
    public List<Role> getRoleListByUserId(String userId) throws Exception {
        Util.validateStr(userId, USER_ID);
        return authorityMapper.getRoleListByUserId(userId);
    }

    /**
     * 根据用户id查询用户权限
     *
     * @param userId
     * @return
     */
    @Override
    public List<Permission> getPermissionListByUserId(String userId) throws Exception {
        Util.validateStr(userId, USER_ID);
        return authorityMapper.getPermissionListByUserId(userId);
    }

    /**
     * 根据角色id查询角色权限
     *
     * @param roleId
     */
    @Override
    public List<Permission> getPermissionListByRoleId(String roleId) throws Exception {
        Util.validateStr(roleId, ROLE_ID);
        return authorityMapper.getPermissionListByRoleId(roleId);
    }

    /**
     * 根据用户邮箱或者手机号获取角色
     *
     * @param mobileOrEmail
     * @return
     */
    @Override
    public List<Role> getRoleListByUserMobileOrEmail(String mobileOrEmail) throws Exception {
        Util.validateStr(mobileOrEmail, MOBILE_OR_EMAIL);
        return authorityMapper.getRoleListByUserMobileOrEmail(mobileOrEmail);
    }

    /**
     * 为用户添加角色
     *
     * @param roleId
     * @param userId
     */
    @Override
    public void addRoleToUser(String roleId, String userId) throws Exception {
        Util.validateStr(roleId, ROLE_ID);
        Util.validateStr(userId, USER_ID);
        UserRole userRole = new UserRole();
        userRole.setUserRoleId(UUID.randomUUID().toString());
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        Date now = new Date();
        userRole.setCreateat(now);
        userRole.setUpdateat(now);
        userRoleMapper.insert(userRole);
    }

    /**
     * 为角色添加权限
     *
     * @param permId
     * @param roleId
     */
    @Override
    public void addPermissionToRole(String permId, String roleId) throws Exception {
        Util.validateStr(permId, PERM_ID);
        Util.validateStr(roleId, ROLE_ID);
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRolePermId(UUID.randomUUID().toString());
        rolePermission.setPermId(permId);
        rolePermission.setRoleId(roleId);
        Date now = new Date();
        rolePermission.setCreateat(now);
        rolePermission.setUpdateat(now);
        rolePermissionMapper.insert(rolePermission);
    }

    /**
     * 为用户删除角色
     *
     * @param roleId
     * @param userId
     */
    @Override
    public void deleteRoleFromUser(String roleId, String userId) throws Exception {
        Util.validateStr(userId, USER_ID);
        Util.validateStr(roleId, ROLE_ID);
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId).andUserIdEqualTo(userId);
        userRoleMapper.deleteByExample(example);
    }

    /**
     * 为角色删除权限
     *
     * @param permId
     * @param roleId
     */
    @Override
    public void deletePermissionFromRole(String permId, String roleId) throws Exception {
        Util.validateStr(permId, PERM_ID);
        Util.validateStr(roleId, ROLE_ID);
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andPermIdEqualTo(permId).andRoleIdEqualTo(roleId);
        rolePermissionMapper.deleteByExample(example);
    }
}
