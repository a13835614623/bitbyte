package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zzk
 * @Date: 2020-02-11 20:25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zzk.bitbyte"})
public class AuditProvider8004_App {
    public static void main(String[] args) {
        SpringApplication.run(AuditProvider8004_App.class, args);
    }
}
