package com.zzk.bitbyte.po.query;

import com.zzk.bitbyte.po.Role;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色查询包装类
 * @Author: zzk
 * @Date: 2020-01-28 22:18
 */
@Data
@Accessors(chain = true)
public class RoleQueryVo extends QueryVo {
    private Role role;
}
