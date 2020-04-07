package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.ActionTopListStatsMapper;
import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.extend.UserExtend;
import com.zzk.bitbyte.po.query.ActionTopListStatsQueryVo;
import com.zzk.bitbyte.po.query.FansTopListStatsQueryVo;
import com.zzk.bitbyte.service.ActionTopListStatsService;
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
public class ActionTopListServiceImpl implements ActionTopListStatsService {

    @Autowired
    ActionTopListStatsMapper actionTopListStatsMapper;

    /**
     * 获取用户粉丝数排行榜
     *
     * @return
     */
    @Override
    public List<UserExtend> getFansNumTopUserList(FansTopListStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return actionTopListStatsMapper.getFansNumTopUserList(queryVo);
    }

    /**
     * 获取博客互动排行榜(包括点赞，阅读,评论)
     *
     * @param queryVo
     * @return
     */
    @Override
    public List<ArticleExtend> getActionNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return actionTopListStatsMapper.getActionNumTopArticleList(queryVo);
    }

    /**
     * 获取阅读量排行
     *
     * @return
     */
    @Override
    public List<ArticleExtend> getReadNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return actionTopListStatsMapper.getReadNumTopArticleList(queryVo);
    }

    /**
     * 获取点赞排行
     *
     * @return
     */
    @Override
    public List<ArticleExtend> getLikeNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return actionTopListStatsMapper.getLikeNumTopArticleList(queryVo);
    }

    /**
     * 获取评论数量
     *
     * @return
     */
    @Override
    public List<ArticleExtend> getCommentNumTopArticleList(ActionTopListStatsQueryVo queryVo) throws Exception {
        Util.validateQueryVo(queryVo);
        return actionTopListStatsMapper.getCommentNumTopArticleList(queryVo);
    }
}
