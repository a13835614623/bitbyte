package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.extend.UserExtend;
import com.zzk.bitbyte.po.query.ActionTopListStatsQueryVo;
import com.zzk.bitbyte.po.query.FansTopListStatsQueryVo;

import java.util.List;

/**
 * 互动数据服务
 * @Author: zzk
 * @Date: 2020-02-06 21:41
 */
public interface ActionTopListStatsService {
    /**
     * 获取用户粉丝数排行榜
     * @return
     */
    List<UserExtend> getFansNumTopUserList(FansTopListStatsQueryVo queryVo) throws Exception;

    /**
     * 获取博客互动排行榜(包括点赞，阅读,评论)
     * @return
     */
    List<ArticleExtend> getActionNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception;

    /**
     * 获取阅读量排行
     * @return
     */
    List<ArticleExtend> getReadNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception;

    /**
     * 获取点赞排行
     * @return
     */
    List<ArticleExtend> getLikeNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception;

    /**
     * 获取评论数量
     * @return
     */
    List<ArticleExtend> getCommentNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception;
}
