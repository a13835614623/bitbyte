package com.zzk.bitbyte.po.extend;

import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.User;
import lombok.Data;

import java.util.List;

/**
 * 用户的包装类
 * 对用户信息进行扩展
 *
 * @author zzk
 */
@Data
public class UserExtend extends User {

    //角色列表
    private List<Role> roleList;

    //权限列表
    private List<Permission> permList;

    // 粉丝数
    private Integer fansNum;
    // 关注数
    private Integer subNum;
}
