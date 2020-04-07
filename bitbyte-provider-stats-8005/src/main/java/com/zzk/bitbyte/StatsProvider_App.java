package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zzk
 * @Date: 2020-02-04 14:54
 */
@SpringBootApplication
@EnableEurekaClient
public class StatsProvider_App {
    public static void main(String[] args) {
        SpringApplication.run(StatsProvider_App.class,args);

    }
}
