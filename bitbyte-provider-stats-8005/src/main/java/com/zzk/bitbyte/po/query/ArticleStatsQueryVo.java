package com.zzk.bitbyte.po.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zzk.bitbyte.po.Article;
import lombok.Data;

import java.util.Date;

/**
 * 博客统计查询包装类
 * @Author: zzk
 * @Date: 2020-02-04 11:35
 */
@Data
public class ArticleStatsQueryVo extends StatsQueryVo {

    private Article article;

    private Date publishTimeStart;
    private Date publishTimeEnd;

    //是否以分区分组
    @JsonProperty("isGroupByPart")
    private boolean isGroupByPart;
    // 是否以发布时间分组
    @JsonProperty("isGroupByPublishTime")
    private boolean isGroupByPublishTime;

}
