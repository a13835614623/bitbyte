package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zzk
 * @Date: 2020-02-19 15:34
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527_App {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527_App.class,args);
    }
}
