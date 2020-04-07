package com.zzk.bitbyte.po.extend;

import com.zzk.bitbyte.po.Comment;
import com.zzk.bitbyte.po.CommentReply;

import java.util.List;

/**
 * 评论扩展类
 *
 * @author zzk
 */
public class CommentExtend extends Comment {
    // 评论回复集合
    private List<CommentReply> commentReplyList;

    public List<CommentReply> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(List<CommentReply> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }

}
