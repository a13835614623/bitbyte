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
    /**
     * 根据查询对象获得角色列表
     * @param vo
     * @return
     */
    List<Role> getRoleListByQueryVo(RoleQueryVo vo);

    /**
     * 根据查询对象获得角色个数
     * @param vo
     * @return
     */
    Integer getRoleCountByQueryVo(RoleQueryVo vo);
}
