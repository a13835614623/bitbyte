package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.AccessStats;
import com.zzk.bitbyte.po.query.AccessStatsQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-05 09:55
 */
@Mapper
public interface AccessStatsMapper {
    /**
     * 根据查询对象获取访问数据
     * @param queryVo
     * @return
     */
    List<AccessStats> getAccessStatsListByQueryVo(AccessStatsQueryVo queryVo);
}
