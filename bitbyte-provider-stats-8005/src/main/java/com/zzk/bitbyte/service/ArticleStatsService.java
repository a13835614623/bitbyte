package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.ArticleStats;
import com.zzk.bitbyte.po.UserStats;
import com.zzk.bitbyte.po.query.ArticleStatsQueryVo;

import java.util.List;

/**
 * 博客数据统计服务
 * @Author: zzk
 * @Date: 2020-02-04 14:43
 */
public interface ArticleStatsService {
    /**
     * 根据查询对象查询count
     * @param queryVo
     * @return
     */
    List<ArticleStats> getArticleStatsListByQueryVo(ArticleStatsQueryVo queryVo) throws Exception;

}
