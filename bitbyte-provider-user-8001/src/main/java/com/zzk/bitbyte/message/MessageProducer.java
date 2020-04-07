package com.zzk.bitbyte.message;

import com.zzk.bitbyte.channel.RecordChannel;
import com.zzk.bitbyte.po.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * 发送到消息队列，添加record
 * @Author: zzk
 * @Date: 2020-02-19 09:52
 */
@EnableBinding(RecordChannel.class)
@Slf4j
public class MessageProducer {

    @Resource(name = RecordChannel.RECORD_OUTPUT)
    private MessageChannel output; // 消息的发送管道

    /**
     * 发送消息
     *
     * @param record
     */
    public void send(Record record) {
        this.output.send(MessageBuilder.withPayload(record).build()); // 创建并发送消息
        log.info("消息发送成功!");
    }
}
