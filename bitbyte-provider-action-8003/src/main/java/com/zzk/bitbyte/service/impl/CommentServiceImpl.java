package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.CommentExtendMapper;
import com.zzk.bitbyte.mapper.CommentMapper;
import com.zzk.bitbyte.mapper.CommentReplyMapper;
import com.zzk.bitbyte.po.Comment;
import com.zzk.bitbyte.po.CommentExample;
import com.zzk.bitbyte.po.CommentReply;
import com.zzk.bitbyte.po.CommentReplyExample;
import com.zzk.bitbyte.po.extend.CommentExtend;
import com.zzk.bitbyte.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentExtendMapper commentExtendMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentReplyMapper commentReplyMapper;

    /**
     * 添加评论
     * @param comment 评论
     * @throws Exception
     */
    @Override
    public void addComment(Comment comment) {
        Assert.notNull(comment,"评论对象不能为空!");
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andCommentArticleEqualTo(comment.getCommentArticle());
        Long count = commentMapper.countByExample(example);
        Date d = new Date();
        comment.setCommentTime(d);
        comment.setCreateat(d);
        comment.setUpdateat(d);
        comment.setCommentFloor(count + 1);
        commentMapper.insert(comment);
    }

    /**
     * 添加评论回复
     * @param reply 评论回复
     * @throws Exception
     */
    @Override
    public void addCommentReply(CommentReply reply) {
        Assert.notNull(reply,"评论回复对象不能为空!");
        CommentReplyExample example = new CommentReplyExample();
        CommentReplyExample.Criteria criteria = example.createCriteria();
        criteria.andReplyCommentArticleEqualTo(reply.getReplyCommentArticle());
        criteria.andReplyCommentFloorEqualTo(reply.getReplyCommentFloor());
        Long count = commentReplyMapper.countByExample(example);
        Date d = new Date();
        reply.setReplyTime(d);
        reply.setCreateat(d);
        reply.setUpdateat(d);
        reply.setReplyFloor(count + 1);
        commentReplyMapper.insert(reply);
    }

    @Override
    public List<CommentExtend> findArticleCommentsById(String articleId) {
        Assert.notNull(articleId,"articleId不能为空!");
        return commentExtendMapper.findArticleCommentsById(articleId);
    }

    @Override
    public Long findUserArticleCommentCountByUserId(String userId) {
        Assert.notNull(userId,"userId不能为空!");
        return commentExtendMapper.findUserArticleCommentCountByUserId(userId);
    }
}
