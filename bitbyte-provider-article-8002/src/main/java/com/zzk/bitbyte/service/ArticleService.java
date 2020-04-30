package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Article;
import com.zzk.bitbyte.po.ArticleWithBLOBs;
import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.query.ArticleQueryVo;
import com.zzk.bitbyte.util.ArticleState;

import java.util.List;

/**
 * 文章接口
 *
 * @author zzk
 */
public interface ArticleService {

    /**
     * 暂存文章
     *
     * @param article
     * @return 文章id
     * @throws Exception
     */
    String tempArticle(ArticleWithBLOBs article) throws Exception;

    /**
     * 发布文章
     *
     * @param articleId 文章id
     * @return
     * @throws Exception
     */
    void publishArticle(String articleId) throws Exception;

    /**
     * 文章提交审核成功
     *
     * @param articleId    文章ID
     * @param articleState 文章状态
     * @throws Exception
     */
    void updateArticleState(String articleId, ArticleState articleState) throws Exception;

    /**
     * 通过文章ID查找文章及其作者+内容信息
     *
     * @param articleId
     * @throws Exception
     */
    ArticleExtend findArticleAndContentById(String articleId) throws Exception;

    /**
     * 通过查询条件查询文章数量
     *
     * @param vo 查询条件
     * @throws Exception
     */
    Integer findArticleCountByQueryVo(ArticleQueryVo vo) throws Exception;


    /**
     * 点赞文章
     *
     * @param userId    点赞用户ID
     * @param articleId 文章ID
     * @throws Exception
     */
    void likeArticle(String userId, String articleId) throws Exception;

    /**
     * 取消点赞
     *
     * @param userId    取消点赞用户ID
     * @param articleId 文章ID
     * @throws Exception
     */
    void dislikeArticle(String userId, String articleId) throws Exception;

    /**
     * 获取用户是否点赞了文章
     *
     * @param userId    用户ID
     * @param articleId 文章ID
     * @return
     * @throws Exception
     */
    boolean isLikeArticle(String userId, String articleId) throws Exception;

    /**
     * 获取文章点赞数量
     *
     * @param articleId
     * @return 文章点赞数量
     * @throws Exception
     */
    Long findArticleLikeCount(String articleId) throws Exception;

    /**
     * 通过用户id查找文章列表
     *
     * @param userId
     * @return 文章列表
     * @
     */
    List<Article> findArticlesByUserId(String userId);


    /**
     * 增加阅读量
     *
     * @throws Exception
     */
    void addArticleReadCount(String articleId,String userId) throws Exception;

    /**
     * 删除文章
     *
     * @param userId
     * @param articleId
     * @throws Exception
     */
    void deleteArticle(String userId, String articleId) throws Exception;

    /**
     * 根据文章查询对象获取文章及其作者简要信息(不包括文章内容)
     *
     * @param articleQueryVo
     * @throws Exception
     */
    List<ArticleExtend> findArticleAndAuthorByQueryVo(ArticleQueryVo articleQueryVo) throws Exception;

    /**
     * 根据用户id查询最新关注的五条动态
     *
     * @param userId
     * @throws Exception
     */
    List<ArticleExtend> findLatestSubArticleAndAuthorByUserId(String userId) throws Exception;

    /**
     * 根据用户的ID生成推荐文章
     * @param userId
     * @return
     * @throws Exception
     */
    List<ArticleExtend> findRecommendArticleList(String userId) throws Exception;

    /**
     * 获取用户发布文章的阅读总数
     * @param userId
     * @return
     * @throws Exception
     */
    Long findArticleReadCountByUserId(String userId) throws Exception;

    /**
     * 根据用户id查询发布文章的点赞数
     * @param userId
     * @return
     */
    Long findArticleLikeCountByUserId(String userId) throws Exception;

}
