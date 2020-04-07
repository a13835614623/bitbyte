package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Message;
import com.zzk.bitbyte.service.MessageService;
import com.zzk.bitbyte.util.Util;
import com.zzk.bitbyte.util.WebSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zzk
 * @Date: 2020-02-18 16:24
 */
@Controller
@Slf4j
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private MessageService messageService;

    /**
     * 收到/user/chat的消息处理
     *
     * @param message
     */
    @MessageMapping(WebSocketChannel.USER_CHAT)
    public void userChat(@Validated Message message, BindingResult bindingResult) throws Exception {
        Util.handleBindingError(bindingResult);
        // 存储消息
        messageService.sendUserMessage(message);
        // 转发给目标用户
        template.convertAndSendToUser(message.getMsgToUser(), WebSocketChannel.USER_CHAT,message);
    }

}
