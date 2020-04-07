package com.zzk.bitbyte.po.extend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户的包装类
 * 对用户信息进行扩展
 *
 * @author zzk
 */
@Setter
@Getter
public class UserExtend extends User {

    @JsonIgnore
    //角色列表
    private List<Role> roleList;

    @JsonIgnore
    //权限列表
    private List<Permission> permList;

}
