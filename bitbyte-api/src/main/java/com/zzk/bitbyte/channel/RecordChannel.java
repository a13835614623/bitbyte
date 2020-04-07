package com.zzk.bitbyte.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 添加记录
 * @Author: zzk
 * @Date: 2020-02-19 11:10
 */
public interface RecordChannel {
    String RECORD_OUTPUT = "record_output"; // 输出通道名称
    String RECORD_INPUT = "record_input"; // 输入通道名称

    @Input(RECORD_INPUT)
    SubscribableChannel recordInput();

    @Output(RECORD_OUTPUT)
    MessageChannel recordOutput();
}
