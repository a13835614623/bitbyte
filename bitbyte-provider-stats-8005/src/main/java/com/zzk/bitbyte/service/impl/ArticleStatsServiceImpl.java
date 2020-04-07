package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.ArticleStatsMapper;
import com.zzk.bitbyte.po.ArticleStats;
import com.zzk.bitbyte.po.query.ArticleStatsQueryVo;
import com.zzk.bitbyte.service.ArticleStatsService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-04 14:43
 */
@Service
@Transactional
public class ArticleStatsServiceImpl implements ArticleStatsService {
    @Autowired
    private ArticleStatsMapper articleStatsMapper;

    /**
     * 根据查询对象查询count
     *
     * @param queryVo
     * @return
     */
    @Override
    public List<ArticleStats> getArticleStatsListByQueryVo(ArticleStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return articleStatsMapper.getArticleStatsListByQueryVo(queryVo);
    }
}
