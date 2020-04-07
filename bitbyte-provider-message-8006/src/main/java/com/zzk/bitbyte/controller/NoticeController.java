package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.po.Notice;
import com.zzk.bitbyte.po.query.NoticeQueryVo;
import com.zzk.bitbyte.service.NoticeService;
import com.zzk.bitbyte.util.ResponseState;
import com.zzk.bitbyte.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

/**
 * @Author: zzk
 * @Date: 2020-03-07 10:55
 */
@RequestMapping("/message/notice")
@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 获取公告
     * @param queryVo
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResponseState getNoticeList(@RequestBody @Valid NoticeQueryVo queryVo,BindingResult bindingResult) throws Exception {
        Util.handleBindingError(bindingResult);
        return ResponseState.success("获取消息成功!").setData(noticeService.findNoticeListByQueryVo(queryVo))
                .setMore(noticeService.findNoticeCountByQueryVo(queryVo));
    }
    /**
     * 客户端订阅了/system/notice后发送给客户端
     *
     * @return
     */
    @RequestMapping("/publish")
    @ResponseBody
    public ResponseState publish(@RequestBody @Valid Notice notice, BindingResult bindingResult) throws Exception {
        Util.handleBindingError(bindingResult);
        notice.setNoticeTime(new Date());
        publishNotice(notice);
        return ResponseState.success("消息发布成功!");
    }

    /**
     * 发布notice并存储到数据库
     * @param notice
     * @throws Exception
     */
    public void publishNotice(Notice notice) throws Exception {
        template.convertAndSend(notice.getNoticeTopic(),notice);
        noticeService.publishNotice(notice);
    }
}
