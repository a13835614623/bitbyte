package com.zzk.bitbyte.util;

import com.sun.mail.util.MailSSLSocketFactory;
import com.zzk.bitbyte.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮箱工具类
 * @Author: zzk
 * @Date: 2020-05-15 10:03
 */
@Component
public class MailUtil {
    @Autowired
    private MailConfig mailConfig;
    private Session session = null;
    private Transport ts;

    private Properties getProp() throws Exception {
        Properties prop = new Properties();
        // 开启debug调试，以便在控制台查看
//		prop.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        prop.setProperty("mail.host", mailConfig.getMailCom());
        // 设置邮件服务器主机名
        prop.setProperty("mail.transport.protocol", "smtp");
        // 发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        return prop;

    }

    /**
     * 发送验证码邮件
     *
     * @param receiveEmail 收件人邮箱地址
     * @param verifyCode   验证码
     * @throws Exception
     */
    public void send(String receiveEmail, String verifyCode) throws Exception {
        // 4.创建邮件
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress(mailConfig.getSenderEmail(), "Biybyte注册验证码"));
        // 指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmail));
        // 邮件的标题
        String s = "【Bitbyte】注册验证码";
        message.setSubject(s);
        // 邮件的文本内容
        message.setContent("<p> 您正在注册Bitbyte网站，验证码：" + verifyCode + "</p>", "text/html;charset=UTF-8");
        message.saveChanges();
        try {
            session = Session.getInstance(this.getProp());
            ts = session.getTransport();
            // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
            session.setDebug(true);
            // 2、通过session得到transport对象
            // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，
            // 用户名和密码都通过验证之后才能够正常发送邮件给收件人。
            ts.connect(mailConfig.getMailCom(), mailConfig.getSenderEmail(), mailConfig.getSendKey());
            if (ts.isConnected()){
                // 5、发送邮件
                ts.sendMessage(message, message.getAllRecipients());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("验证码发送失败!");
        }
    }

}
