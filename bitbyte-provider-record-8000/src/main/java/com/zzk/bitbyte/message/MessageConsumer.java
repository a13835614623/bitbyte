package com.zzk.bitbyte.message;

import com.zzk.bitbyte.channel.RecordChannel;
import com.zzk.bitbyte.po.Record;
import com.zzk.bitbyte.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @Author: zzk
 * @Date: 2020-02-19 13:14
 */
@Slf4j
@EnableBinding({RecordChannel.class})
public class MessageConsumer extends AbstractMessageConsumer{

    @Autowired
    private RecordService recordService;

    /**
     * 监听[记录添加]消息
     * @param message
     */
    @StreamListener(RecordChannel.RECORD_INPUT)
    public void input(Message<Record> message){
        log.info("[记录添加]消息接收成功！");
        Record record = message.getPayload();
        try {
            recordService.addRecord(record.getRecordContent(),record.getRecordUser());
            log.info("[记录添加]消息消费成功！");
        } catch (Exception e) {
            log.info("[记录添加]消息消费失败!");
            e.printStackTrace();
        }
    }
}
