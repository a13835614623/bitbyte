package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:评论管理
 * @Author: zzk
 * @Date: 2020-01-19 10:52
 */
@SpringBootApplication
@EnableEurekaClient
public class ActionProvider8003_App {
    public static void main(String[] args) {
        SpringApplication.run(ActionProvider8003_App.class,args);
    }
}
