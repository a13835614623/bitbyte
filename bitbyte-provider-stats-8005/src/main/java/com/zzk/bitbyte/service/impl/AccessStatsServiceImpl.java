package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.AccessStatsMapper;
import com.zzk.bitbyte.po.AccessStats;
import com.zzk.bitbyte.po.query.AccessStatsQueryVo;
import com.zzk.bitbyte.service.AccessStatsService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-05 13:38
 */
@Service
@Transactional
public class AccessStatsServiceImpl implements AccessStatsService {

    @Autowired
    AccessStatsMapper accessStatsMapper;

    /**
     * 根据查询对象获取访问数据
     *
     * @param queryVo
     * @return
     */
    @Override
    public List<AccessStats> getAccessStatsListByQueryVo(AccessStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return accessStatsMapper.getAccessStatsListByQueryVo(queryVo);
    }
}
