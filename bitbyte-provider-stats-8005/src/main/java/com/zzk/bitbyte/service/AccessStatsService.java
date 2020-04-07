package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.AccessStats;
import com.zzk.bitbyte.po.query.AccessStatsQueryVo;

import java.util.List;

/**
 * 访问量数据统计服务
 * @Author: zzk
 * @Date: 2020-02-05 09:56
 */
public interface AccessStatsService {

    /**
     * 根据查询对象获取访问数据
     * @param queryVo
     * @return
     */
    List<AccessStats> getAccessStatsListByQueryVo(AccessStatsQueryVo queryVo) throws Exception;
}
