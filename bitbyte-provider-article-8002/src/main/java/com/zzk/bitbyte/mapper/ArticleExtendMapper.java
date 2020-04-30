package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.Article;
import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.query.ArticleQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文章扩展类mapper
 *
 * @author zzk
 */
@Mapper
public interface ArticleExtendMapper {

    /**
     * 根据id获取文章及其作者简要信息(包括文章内容)
     *
     * @param articleId
     * @throws Exception
     */
    ArticleExtend findArticleExtendById(String articleId);

    /**
     * 根据用户id查询发布文章的阅读量
     * @param userId
     * @return
     */
    @Select("select sum(a.article_read) from article a where a.article_user=#{userId} and a.article_state=28")
    Long findArticleReadCountByUserId(String userId);

    /**
     * 获取随机数据
     * @param count 数量
     * @return
     */
    List<String> findRandomArticleIdWithAuthor(Integer count);

    /**
     * 根据id获取文章及其作者简要信息(不包括文章内容)
     * @param articleId
     * @return
     * @throws Exception
     */
    ArticleExtend findArticleWithAuthorById(String articleId) throws Exception;

    /**
     * 根据文章查询对象获取文章及其作者简要信息(不包括文章内容)
     *
     * @param articleQueryVo
     * @throws Exception
     */
    List<ArticleExtend> findArticleAndAuthorByQueryVo(ArticleQueryVo articleQueryVo) throws Exception;

    /**
     * 通过查询条件查询文章数量
     *
     * @param vo 查询条件
     * @throws Exception
     */
    Integer findArticleCountByQueryVo(ArticleQueryVo vo) throws Exception;

    /**
     * 根据用户id查询最新关注的五条动态
     *
     * @param userId
     * @throws Exception
     */
    List<ArticleExtend> findLatestSubArticleAndAuthorByUserId(String userId) throws Exception;

    /**
     * 批量更新文章阅读量
     * @param articles
     * @throws Exception
     */
    void updateArticleRead(List<Article> articles) throws Exception;

}
