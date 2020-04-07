package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.PermissionExtendMapper;
import com.zzk.bitbyte.mapper.PermissionMapper;
import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.query.PermissionQueryVo;
import com.zzk.bitbyte.service.PermissionService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:26
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    PermissionExtendMapper permissionExtendMapper;

    /**
     * 根据查询对象查询权限
     *
     * @param vo
     */
    @Override
    public List<Permission> getPermissionListByQueryVo(PermissionQueryVo vo) throws Exception {
        Util.validateQueryVo(vo);
        return permissionExtendMapper.getPermissionListByQueryVo(vo);
    }

    @Override
    public Integer getPermissionCountByQueryVo(PermissionQueryVo vo) throws Exception {
        Util.validateQueryVo(vo);
        return permissionExtendMapper.getPermissionCountByQueryVo(vo);
    }

    /**
     * 添加权限
     *
     * @param permission
     */
    @Override
    public void addPermission(Permission permission) throws Exception {
        Util.validateObj(permission,PERM);
        permission.setPermId(UUID.randomUUID().toString());
        Date now = new Date();
        permission.setCreateat(now);
        permission.setUpdateat(now);
        permissionMapper.insert(permission);
    }

    /**
     * 根据权限id删除权限
     *
     * @param permId
     */
    @Override
    public void deletePermissionByPermId(String permId) throws Exception {
        Util.validateStr(permId,PERM_ID);
        permissionMapper.deleteByPrimaryKey(permId);
    }

    /**
     * 更新权限
     *
     * @param permission
     */
    @Override
    public void updatePermission(Permission permission) throws Exception {
        Util.validateObj(permission,PERM);
        permission.setUpdateat(new Date());
        permissionMapper.updateByPrimaryKeySelective(permission);
    }
}
