package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zzk
 * @Date: 2020-02-18 12:04
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer8888_App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer8888_App.class,args);
    }
}
