package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.extend.UserExtend;
import com.zzk.bitbyte.po.query.ActionTopListStatsQueryVo;
import com.zzk.bitbyte.po.query.FansTopListStatsQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzk
 * @Date: 2020-02-06 21:18
 */
@Mapper
public interface ActionTopListStatsMapper {
    /**
     * 获取用户粉丝数排行榜
     * @return
     */
    List<UserExtend> getFansNumTopUserList(FansTopListStatsQueryVo queryVo);

    /**
     * 获取博客互动排行榜(包括点赞，阅读,评论)
     * @return
     */
    List<ArticleExtend> getActionNumTopArticleList(ActionTopListStatsQueryVo queryVo);

    /**
     * 获取阅读量排行
     * @return
     */
    List<ArticleExtend> getReadNumTopArticleList(ActionTopListStatsQueryVo queryVo);

    /**
     * 获取点赞排行
     * @return
     */
    List<ArticleExtend> getLikeNumTopArticleList(ActionTopListStatsQueryVo queryVo);

    /**
     * 获取评论数量
     * @return
     */
    List<ArticleExtend> getCommentNumTopArticleList(ActionTopListStatsQueryVo queryVo);

}
