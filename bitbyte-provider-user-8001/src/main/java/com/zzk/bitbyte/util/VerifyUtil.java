package com.zzk.bitbyte.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 验证码工具类
 *
 * @Author: zzk
 * @Date: 2020-05-15 10:51
 */
@Component
public class VerifyUtil {
    public static final String VERIFY_KEY = "verify:reg:";
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MailUtil mailUtil;

    public static Random random = new Random();

    /**
     * 生成验证码
     */
    private String build() {
        StringBuilder res = new StringBuilder();
        while (true) {
            res.append(random.nextInt(10));
            if (res.length() == 6) {
                break;
            }
        }
        return res.toString();
    }

    /**
     * 验证验证码
     * @return
     */
    public void verify(String email,String verifyCode) throws Exception {
        Object code = redisUtil.get(VERIFY_KEY + email);
        if (code!=null&&code.toString().equals(verifyCode)){
            return ;
        }
        throw new Exception("验证失败!");
    }

    /**
     * 发送验证码
     * @param receiveEmail
     * @throws Exception
     */
    public void send(String receiveEmail) throws Exception {
        // 验证码
        String code = build();
        // 验证码有效时间十分钟
        redisUtil.set(VERIFY_KEY + receiveEmail, code,600);
        try {
            mailUtil.send(receiveEmail, code);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("验证码发送失败!");
        }
    }
}
