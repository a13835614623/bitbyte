package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.query.PermissionQueryVo;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:22
 */
public interface PermissionService {

    String PERM="角色";
    String PERM_ID=PERM+"ID";

    /**
     * 根据查询对象查询权限
     * @param vo
     */
    List<Permission> getPermissionListByQueryVo(PermissionQueryVo vo) throws Exception;

    /**
     * 根据查询对象查询数量
     * @param vo
     * @return
     */
    Integer getPermissionCountByQueryVo(PermissionQueryVo vo) throws Exception;

    /**
     * 添加权限
     * @param permission
     */
    void addPermission(Permission permission) throws Exception;

    /**
     * 根据权限id删除权限
     * @param permId
     */
    void deletePermissionByPermId(String permId) throws Exception;

    /**
     * 更新权限
     * @param permission
     */
    void updatePermission(Permission permission) throws Exception;
}
