package com.zzk.bitbyte.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 邮箱配置
 * @Author: zzk
 * @Date: 2020-05-15 10:34
 */
@Component
public class MailConfig {
    @Value("${mail.com}")
    private String mailCom;

    @Value("${mail.sender.address}")
    private String senderEmail;

    @Value("${mail.sender.key}")
    private String sendKey;

    public String getMailCom() {
        return mailCom;
    }

    public void setMailCom(String mailCom) {
        this.mailCom = mailCom;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSendKey() {
        return sendKey;
    }

    public void setSendKey(String sendKey) {
        this.sendKey = sendKey;
    }
}
