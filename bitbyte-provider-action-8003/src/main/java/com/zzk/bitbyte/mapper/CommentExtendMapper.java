package com.zzk.bitbyte.mapper;

import com.zzk.bitbyte.po.extend.CommentExtend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentExtendMapper {
    /**
     * 获得文章所有的评论
     *
     * @return
     * @throws Exception
     */
    public List<CommentExtend> findArticleCommentsById(String articleId);

    /**
     * 根据用户ID获取发布文章的评论数量
     * @param userId
     * @return
     */
    Long findUserArticleCommentCountByUserId(String userId);
}
