package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.UserFansStats;
import com.zzk.bitbyte.po.query.UserFansStatsQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-04-12 14:15
 */
@Mapper
public interface UserFansStatsMapper {
    /**
     * 获取粉丝数stats根据查询对象
     * @param queryVo
     * @return
     */
    List<UserFansStats> getFansStatsListByQueryVo(UserFansStatsQueryVo queryVo);

}
