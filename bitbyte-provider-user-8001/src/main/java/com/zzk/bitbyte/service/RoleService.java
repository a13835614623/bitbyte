package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.query.RoleQueryVo;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:15
 */
public interface RoleService {
    String ROLE="角色";
    String ROLE_ID="角色ID";
    /**
     * 根据查询对象查询角色
     * @param vo
     */
    List<Role> getRoleListByQueryVo(RoleQueryVo vo) throws Exception;

    /**
     * 根据查询对象查询数量
     * @param vo
     * @return
     */
    Integer getRoleCountByQueryVo(RoleQueryVo vo) throws Exception;

    /**
     * 添加角色
     * @param role
     */
    void addRole(Role role) throws Exception;

    /**
     * 根据角色id删除角色
     * @param roleId
     */
    void deleteRoleByRoleId(String roleId) throws Exception;

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role) throws Exception;
}
