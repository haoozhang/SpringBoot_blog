package com.zhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync  // 开启异步注解
@EnableScheduling  // 开启定时注解
public class SpringBootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskApplication.class, args);
    }

}
