package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.cache.UserAuthCacheManager;
import com.zzk.bitbyte.service.AuthorityService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * shiro安全控制器
 *
 * @Author: zzk
 * @Date: 2020-01-28 22:13
 */
@RestController
@RequestMapping("/user/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @Autowired
    UserAuthCacheManager userAuthCacheManager;

    /**
     * 根据用户id获取角色列表
     *
     * @param userId
     * @return
     */
    @RequestMapping("/role/get/{userId}")
    public ResponseState getRoleListByUserId(@PathVariable("userId") String userId) throws Exception {
        return ResponseState.success("获取角色成功", null)
                .setData(authorityService.getRoleListByUserId(userId));
    }

    /**
     * 根据用户id或者角色id获取权限列表
     *
     * @param id 用户id/角色id
     * @return
     */
    @RequestMapping("/perm/get/{id}")
    public ResponseState getPermissionListByUserId(@PathVariable("id") String id,
                                                   @RequestParam("name") String name) throws Exception {
        ResponseState state = ResponseState.success("获取权限成功", null);
        if ("user".equals(name)) {
            return state.setData(authorityService.getPermissionListByUserId(id));
        } else if ("role".equals(name)) {
            return state.setData(authorityService.getPermissionListByRoleId(id));
        } else {
            return state.setStatus(ResponseState.STATUS_ERROR).setMessage("参数值name非法!");
        }
    }

    /**
     * 为用户添加角色
     *
     * @param roleId
     * @param userId
     */
    @RequestMapping("/role/add")
    public ResponseState addRoleToUser(@RequestParam("userId") String userId,
                                       @RequestParam(value = "roleId", required = false) String roleId,
                                       @RequestBody List<String> roleIdList) throws Exception {
        if (!Util.isEmpty(roleId))
            authorityService.addRoleToUser(roleId, userId);
        else {
            int len = roleIdList.size();
            for (int i = 0; i < len; i++) {
                authorityService.addRoleToUser(roleIdList.get(i), userId);
            }
        }
        userAuthCacheManager.deleteAuthInfoCache(userId);
        return ResponseState.success("角色添加成功!", null);
    }

    /**
     * 为角色删除权限
     *
     * @param permId
     * @param roleId
     */
    @RequestMapping("/perm/delete")
    public ResponseState deletePermissionFromRole(@RequestParam("roleId") String roleId,
                                             @RequestParam(value = "permId", required = false) String permId,
                                             @RequestBody List<String> permIdList) throws Exception {
        if (!Util.isEmpty(permId))
            authorityService.deletePermissionFromRole(permId, roleId);
        else {
            int len = permIdList.size();
            for (int i = 0; i < len; i++) {
                authorityService.deletePermissionFromRole(permIdList.get(i),roleId);
            }
        }
        return ResponseState.success("权限删除成功!", null);
    }


    /**
     * 为用户删除角色
     *
     * @param roleId
     * @param userId
     */
    @RequestMapping("/role/delete")
    public ResponseState deleteRoleFromUser(@RequestParam("userId") String userId,
                                       @RequestParam(value = "roleId", required = false) String roleId,
                                       @RequestBody List<String> roleIdList) throws Exception {
        if (!Util.isEmpty(roleId))
            authorityService.deleteRoleFromUser(roleId, userId);
        else {
            int len = roleIdList.size();
            for (int i = 0; i < len; i++) {
                authorityService.deleteRoleFromUser(roleIdList.get(i), userId);
            }
        }
        userAuthCacheManager.deleteAuthInfoCache(userId);
        return ResponseState.success("角色删除成功!", null);
    }

    /**
     * 为角色添加权限
     *
     * @param permId
     * @param roleId
     */
    @RequestMapping("/perm/add")
    public ResponseState addPermissionToRole(@RequestParam("roleId") String roleId,
                                             @RequestParam(value = "permId", required = false) String permId,
                                             @RequestBody List<String> permIdList) throws Exception {
        if (!Util.isEmpty(permId))
            authorityService.addPermissionToRole(permId, roleId);
        else {
            int len = permIdList.size();
            for (int i = 0; i < len; i++) {
                authorityService.addPermissionToRole(permIdList.get(i),roleId);
            }
        }
        return ResponseState.success("权限添加成功!", null);
    }
}
