package com.zzk.bitbyte.po.query;

import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.User;
import com.zzk.bitbyte.po.extend.UserExtend;
import lombok.Data;

/**
 * 用户查询包装类
 * @className: UserQueryVo
 * @author: zzk
 * @date: 2020-01-20 20:35
 */
@Data
public class UserQueryVo extends QueryVo{
    //在这里可以包装查询条件
    private UserExtend user;
    // 角色
    private Role role;
}
