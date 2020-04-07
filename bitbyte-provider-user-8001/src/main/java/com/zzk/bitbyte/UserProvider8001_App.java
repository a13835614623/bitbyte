package com.zzk.bitbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserProvider8001_App {
	public static void main(String[] args) {
		SpringApplication.run(UserProvider8001_App.class, args);
	}
}
