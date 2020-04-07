package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.ArticleStats;
import com.zzk.bitbyte.po.query.ArticleStatsQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-03 20:24
 */
@Mapper
public interface ArticleStatsMapper{

    /**
     * 根据查询对象查询count
     * @param queryVo
     * @return
     */
    List<ArticleStats> getArticleStatsListByQueryVo(ArticleStatsQueryVo queryVo);

}
