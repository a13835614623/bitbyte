package com.zzk.bitbyte.service;

import com.zzk.bitbyte.po.Message;

/**
 * 用户消息服务
 * @Author: zzk
 * @Date: 2020-03-06 22:28
 */
public interface MessageService {
    /**
     * 发送消息
     * @param message
     */
    void sendUserMessage(Message message) throws Exception;

}
