package com.zzk.bitbyte.po;

import javax.validation.constraints.*;
import java.util.Date;

public class Message {
    private String msgId;

    @NotBlank(message = "消息内容不能为空!")
    private String msgContent;

    @NotBlank(message = "消息发送者不能为空!")
    private String msgFromUser;

    @NotBlank(message = "消息接收者不能为空!")
    private String msgToUser;

    @NotNull(message = "消息发送时间不能为空!")
    @PastOrPresent(message = "消息发送时间不合法!")
    private Date msgSendTime;

    private Date createat;

    private Date udpateat;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getMsgFromUser() {
        return msgFromUser;
    }

    public void setMsgFromUser(String msgFromUser) {
        this.msgFromUser = msgFromUser == null ? null : msgFromUser.trim();
    }

    public String getMsgToUser() {
        return msgToUser;
    }

    public void setMsgToUser(String msgToUser) {
        this.msgToUser = msgToUser == null ? null : msgToUser.trim();
    }

    public Date getMsgSendTime() {
        return msgSendTime;
    }

    public void setMsgSendTime(Date msgSendTime) {
        this.msgSendTime = msgSendTime;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUdpateat() {
        return udpateat;
    }

    public void setUdpateat(Date udpateat) {
        this.udpateat = udpateat;
    }
}