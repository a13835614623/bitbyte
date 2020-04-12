package com.zzk.bitbyte.po.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: zzk
 * @Date: 2020-04-12 14:26
 */
@Data
public class UserArticlesStatsQueryVo extends StatsQueryVo {
    private String userId;

    private Date timeStart;

    private Date timeEnd;
    /**
     * 阅读分组
     */
    @JsonProperty("isGroupByRead")
    private boolean isGroupByRead;
    /**
     * 评论分组
     */
    @JsonProperty("isGroupByComment")
    private boolean isGroupByComment;
    /**
     * 点赞分组
     */
    @JsonProperty("isGroupByLike")
    private boolean isGroupByLike;

    /**
     * 收藏分组
     */
    @JsonProperty("isGroupByFavorite")
    private boolean isGroupByFavorite;

}
