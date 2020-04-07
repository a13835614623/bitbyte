package com.zzk.bitbyte.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzk.bitbyte.channel.AuditEndChannel;
import com.zzk.bitbyte.controller.NoticeController;
import com.zzk.bitbyte.po.Notice;
import com.zzk.bitbyte.po.extend.ArticleExtend;
import com.zzk.bitbyte.po.extend.AuditExtend;
import com.zzk.bitbyte.util.Util;
import com.zzk.bitbyte.util.WebSocketChannel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.util.Date;

/**
 * 监听审核结束消息
 *
 * @Author: zzk
 * @Date: 2020-02-19 14:36
 */
@EnableBinding(AuditEndChannel.class)
@Slf4j
public class MessageConsumer extends AbstractMessageConsumer{
    @Autowired
    private NoticeController controller;

    /**
     * 监听[审核结束]消息,并转发到客户端
     *
     * @param message
     */
    @StreamListener(AuditEndChannel.AUDIT_END_INPUT)
    void auditEndInput(Message<AuditExtend> message){
        log.info("收到[审核结束]消息");
        try {
            // 转发给博客作者
            controller.publishNotice(convert(message));
        }catch (Exception e){
            log.error("[审核结束]消息发送失败",e);
        }
        log.info("发送给客户端[审核结束]消息");
    }

    Notice convert(Message<AuditExtend> message) throws JsonProcessingException {
        AuditExtend auditExtend = message.getPayload();
        ArticleExtend articleExtend = auditExtend.getArticle();
        AuditMessage auditMessage = new AuditMessage();
        auditMessage.setArticleTitle(articleExtend.getArticleTitle())
                .setAuditReason(auditExtend.getAuditReason())
                .setAuditState(auditExtend.getAuditState());
        Notice notice = new Notice();
        notice.setNoticeTitle("系统消息");
        notice.setNoticeContent(Util.bean2Json(auditMessage));
        notice.setNoticeTime(new Date());
        notice.setNoticeTopic("/user/"+auditExtend.getArticle().getArticleUser()+ WebSocketChannel.AUDIT_END);
        return notice;
    }

    @Data
    @Accessors(chain = true)
    private static class AuditMessage {
        private Integer auditState;
        private String auditReason;
        private String articleTitle;
    }
}
