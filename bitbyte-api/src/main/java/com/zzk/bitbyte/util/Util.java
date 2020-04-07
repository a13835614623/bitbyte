package com.zzk.bitbyte.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 字符串工具类
 *
 * @author zzk
 */
public class Util {
    /**
     * 字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0 || s == "";
    }

    /**
     * 校验字符串
     *
     * @param s
     * @param msg
     * @throws Exception
     */
    public static void validateStr(String s, String msg) throws Exception {
        if (isEmpty(s)) throw new Exception(msg + ValidateMessage.NOT_BLANK);
    }

    /**
     * 校验字符串
     *
     * @param s
     * @throws Exception
     */
    public static void validateQueryVo(Object o) throws Exception {
        Assert.notNull(o, ValidateMessage.QUERY_NOT_NULL);
    }

    /**
     * 校验对象
     *
     * @param o
     * @param msg
     * @throws Exception
     */
    public static void validateObj(Object o, String msg) throws Exception {
        Assert.notNull(o, msg + ValidateMessage.NOT_BLANK);
    }

    /**
     * 处理验证错误
     *
     * @param bindingResult
     * @throws Exception
     */
    public static void handleBindingError(BindingResult bindingResult) throws Exception {
        // 获取校验错误信息
        if (bindingResult != null && bindingResult.hasErrors()) {
            // 获得所有ERROR
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                throw new Exception(objectError.getDefaultMessage());
            }
        }
    }

    public static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转json
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String bean2Json(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * json字符串转对象
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T json2Bean(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * localDateTime转Date
     *
     * @param localDateTime
     * @return
     */
    Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static final Random RANDOM = new Random();
    public static final long _1DAY = TimeUnit.DAYS.toSeconds(1);

    /**
     * 随机天数
     *
     * @return
     */
    public static long randomExpTime(int days) {
        return days * _1DAY + RANDOM.nextInt((int) (days * _1DAY));
    }

}
