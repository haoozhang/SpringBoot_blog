package com.zhao.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {

    @Scheduled(cron = "0 39 16 * * ?") // cron 表达式：秒 分 时 日 月 星期
    public void hello() {
        System.out.println("executed!");
    }
}
