package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.query.PermissionQueryVo;
import com.zzk.bitbyte.service.PermissionService;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:39
 */
@RestController
@RequestMapping("/user/perm")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/add")
    public ResponseState addPermission(@RequestBody Permission permission) throws Exception {
        permissionService.addPermission(permission);
        return ResponseState.success("添加成功!");
    }

    @RequestMapping("/delete/{permId}")
    public ResponseState deletePermissionByPermissionId(@PathVariable("permId") String permId) throws Exception {
        permissionService.deletePermissionByPermId(permId);
        return ResponseState.success("删除成功!");
    }

    @RequestMapping("/update")
    public ResponseState updatePermission(@RequestBody Permission permission) throws Exception {
        permissionService.updatePermission(permission);
        return ResponseState.success("更新成功!");
    }

    @RequestMapping("/list")
    public ResponseState list(@RequestBody PermissionQueryVo vo) throws Exception {
        return ResponseState.success("查询成功")
                .setData(permissionService.getPermissionListByQueryVo(vo))
                .setMore(permissionService.getPermissionCountByQueryVo(vo));
    }

    @RequestMapping("/count")
    public ResponseState count(@RequestBody PermissionQueryVo vo) throws Exception {
        return ResponseState.success("查询成功").setData(permissionService.getPermissionCountByQueryVo(vo));
    }
}
