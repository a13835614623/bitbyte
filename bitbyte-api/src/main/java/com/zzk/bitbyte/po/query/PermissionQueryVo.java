package com.zzk.bitbyte.po.query;

import com.zzk.bitbyte.po.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 权限查询包装类
 *
 * @Author: zzk
 * @Date: 2020-01-28 22:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class PermissionQueryVo extends QueryVo {
    private Permission perm;
}
