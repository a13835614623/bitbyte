package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.RoleExtendMapper;
import com.zzk.bitbyte.mapper.RoleMapper;
import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.query.RoleQueryVo;
import com.zzk.bitbyte.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleExtendMapper roleExtendMapper;
    @Autowired
    RoleMapper roleMapper;

    /**
     * 根据查询对象查询角色
     *
     * @param vo
     */
    @Override
    public List<Role> getRoleListByQueryVo(RoleQueryVo vo) throws Exception {
        Util.validateQueryVo(vo);
        return roleExtendMapper.getRoleListByQueryVo(vo);
    }

    @Override
    public Integer getRoleCountByQueryVo(RoleQueryVo vo) throws Exception {
        Util.validateQueryVo(vo);
        return roleExtendMapper.getRoleCountByQueryVo(vo);
    }

    /**
     * 添加角色
     *
     * @param role
     */
    @Override
    public void addRole(Role role) throws Exception {
        Util.validateObj(role,ROLE);
        role.setRoleId(UUID.randomUUID().toString());
        Date now = new Date();
        role.setCreateat(now);
        role.setUpdateat(now);
        roleMapper.insert(role);
    }

    /**
     * 根据角色id删除角色
     *
     * @param roleId
     */
    @Override
    public void deleteRoleByRoleId(String roleId) throws Exception {
        Util.validateObj(roleId,ROLE_ID);
        roleMapper.deleteByPrimaryKey(roleId);
    }

    /**
     * 更新角色
     *
     * @param role
     */
    @Override
    public void updateRole(Role role) throws Exception {
        Util.validateObj(role,ROLE);
        role.setUpdateat(new Date());
        roleMapper.updateByPrimaryKeySelective(role);
    }
}
