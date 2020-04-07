package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Role;
import com.zzk.bitbyte.po.query.RoleQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:31
 */
@Mapper
public interface RoleExtendMapper {
    List<Role> getRoleListByQueryVo(RoleQueryVo vo);
    Integer getRoleCountByQueryVo(RoleQueryVo vo);
}
