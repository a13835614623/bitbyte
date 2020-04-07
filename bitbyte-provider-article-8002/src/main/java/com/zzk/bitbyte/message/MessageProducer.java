package com.zzk.bitbyte.message;

import com.zzk.bitbyte.channel.AuditChannel;
import com.zzk.bitbyte.channel.RecordChannel;
import com.zzk.bitbyte.po.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * 发送消息到消息队列
 * @Author: zzk
 * @Date: 2020-02-19 09:52
 */
@EnableBinding({RecordChannel.class, AuditChannel.class})
@Slf4j
public class MessageProducer {

    /**
     * [添加记录]
     */
    @Resource(name = RecordChannel.RECORD_OUTPUT)
    private MessageChannel recordOutput; // 消息的发送管道

    /**
     *[审核提交]
     */
    @Resource(name = AuditChannel.AUDIT_OUTPUT)
    private MessageChannel auditOutput; // 消息的发送管道

    /**
     * 发送[添加记录]消息
     *
     * @param record
     */
    public void sendRecord(Record record) {
        this.recordOutput.send(MessageBuilder.withPayload(record).build()); // 创建并发送消息
        log.info("[添加记录]消息发送成功!");
    }

    /**
     * 发送[提交审核]消息
     * @param articleId
     */
    public void sendCommitAudit(String articleId) {
        this.auditOutput.send(MessageBuilder.withPayload(articleId).build()); // 创建并发送消息
        log.info("[审核提交]消息发送成功!");
    }

}
