package com.zzk.bitbyte.po.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zzk.bitbyte.po.Article;
import lombok.Data;

import java.util.Date;

/**
 * 博客互动排行榜查询对象
 * @Author: zzk
 * @Date: 2020-02-06 21:11
 */
@Data
public class ActionTopListStatsQueryVo extends StatsQueryVo {
    private Article article;

    // 是否以点赞数量排序(降序)
    @JsonProperty("isOrderByLikeNum")
    private boolean isOrderByLikeNum;
    // 是否以评论数量排序(降序)
    @JsonProperty("isOrderByCommentNum")
    private boolean isOrderByCommentNum;
    // 是否以阅读量排序(降序)
    @JsonProperty("isOrderByReadNum")
    private boolean isOrderByReadNum;

    private Date publishTimeStart;
    private Date publishTimeEnd;
}
