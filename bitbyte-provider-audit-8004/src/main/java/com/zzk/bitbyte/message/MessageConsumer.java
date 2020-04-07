package com.zzk.bitbyte.message;

import com.zzk.bitbyte.channel.AuditChannel;
import com.zzk.bitbyte.channel.AuditEndChannel;
import com.zzk.bitbyte.po.Audit;
import com.zzk.bitbyte.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @Author: zzk
 * @Date: 2020-02-22 15:16
 */
@Slf4j
@EnableBinding({AuditChannel.class, AuditEndChannel.class})
public class MessageConsumer extends AbstractMessageConsumer {

    @Qualifier("auditServiceImpl")
    @Autowired
    AuditService auditService;

    @Autowired
    MessageProducer messageProducer;
    /**
     * 监听[提交审核]消息
     * @param message
     */
    @StreamListener(AuditChannel.AUDIT_INPUT)
    public void input(Message<String> message) throws Exception {
        String articleId = message.getPayload();
        log.info("[审核提交]消息接收成功!");
        Audit audit = auditService.addAudit(articleId);
        log.info("[审核提交]消息消费成功!");
        // 发送审核成功消息
        messageProducer.sendAuditCommitSuccess(articleId);
    }
}
