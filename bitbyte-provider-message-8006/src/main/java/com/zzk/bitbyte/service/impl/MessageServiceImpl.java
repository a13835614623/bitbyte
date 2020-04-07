package com.zzk.bitbyte.service.impl;

import com.zzk.bitbyte.mapper.MessageMapper;
import com.zzk.bitbyte.po.Message;
import com.zzk.bitbyte.service.MessageService;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-03-06 22:29
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    /**
     * 发送消息
     * @param message
     */
    @Override
    public void sendUserMessage(Message message) throws Exception {
        Util.validateObj(message,"消息");
        Date now = new Date();
        message.setMsgId(UUID.randomUUID().toString());
        message.setCreateat(now);
        message.setUdpateat(now);
        message.setMsgSendTime(now);
        messageMapper.insert(message);
    }
}
