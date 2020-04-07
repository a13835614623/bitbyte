package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zzk
 * @Date: 2020-02-19 10:32
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageProvider8006_App {
    public static void main(String[] args) {
        SpringApplication.run(MessageProvider8006_App.class, args);
    }
}
