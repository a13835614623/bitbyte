package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Permission;
import com.zzk.bitbyte.po.query.PermissionQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-01-28 22:30
 */
@Mapper
public interface PermissionExtendMapper {

    List<Permission> getPermissionListByQueryVo(PermissionQueryVo vo);

    Integer getPermissionCountByQueryVo(PermissionQueryVo vo);

}
