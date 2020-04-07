package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.query.RoleQueryVo;
import com.zzk.bitbyte.service.RoleService;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:40
 */
@RestController
@RequestMapping("/user/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/add")
    public ResponseState addRole(@RequestBody Role role) throws Exception {
        roleService.addRole(role);
        return ResponseState.success("添加成功!",null);
    }

    @RequestMapping("/delete/{roleId}")
    public ResponseState deleteRoleByRoleId(@PathVariable("roleId") String roleId) throws Exception {
        roleService.deleteRoleByRoleId(roleId);
        return ResponseState.success("删除成功!",null);
    }

    @RequestMapping("/update")
    public ResponseState updateRole(@RequestBody Role role) throws Exception {
        roleService.updateRole(role);
        return ResponseState.success("更新成功!");
    }

    @RequestMapping("/list")
    public ResponseState list(@RequestBody RoleQueryVo vo) throws Exception {
        return ResponseState.success("查询成功")
                .setData(roleService.getRoleListByQueryVo(vo))
                .setMore(roleService.getRoleCountByQueryVo(vo));
    }

    @RequestMapping("/count")
    public ResponseState count(@RequestBody RoleQueryVo vo) throws Exception {
        return ResponseState.success("查询成功")
                .setData(roleService.getRoleCountByQueryVo(vo));
    }
}
