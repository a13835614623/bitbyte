package com.zzk.bitbyte.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 图片路径配置
 * @author zzk
 *
 */
@Component
public class PathConfig {
    @Value("${pic.path}")
    private String picPath;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
