package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Comment;
import com.zzk.bitbyte.po.CommentReply;
import com.zzk.bitbyte.po.extend.CommentExtend;

import java.util.List;

public interface CommentService {
    /**
     * 获得文章所有的评论
     *
     * @return 带回复的评论集合
     * @throws Exception
     */
    List<CommentExtend> findArticleCommentsById(String articleId);

    /**
     * 添加评论
     *
     * @param comment 评论
     * @throws Exception
     */
    void addComment(Comment comment);

    /**
     * 添加评论回复
     *
     * @param reply 评论回复
     * @throws Exception
     */
    void addCommentReply(CommentReply reply);
}
