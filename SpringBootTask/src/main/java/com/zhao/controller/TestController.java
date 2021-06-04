package com.zhao.controller;


import com.zhao.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class TestController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "ok";
    }

    @Autowired
    private JavaMailSenderImpl mailSender;

    @GetMapping("/mail1")
    public String mail1() {
        // 简单邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Mail 1 Test");
        mailMessage.setText("Mail 1 Test");
        mailMessage.setFrom("1322693823@qq.com");
        mailMessage.setTo("h.zhang@smail.nju.edu.cn");
        mailSender.send(mailMessage);

        return "mail1";
    }

    @GetMapping("/mail2")
    public String mail2() throws MessagingException {
        // 复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); // 支持多文件
        helper.setSubject("Mail 2 Test");
        helper.setText("<p style='color:red'>Mail 2 Test</p>", true);  // 支持 html
        helper.setFrom("1322693823@qq.com");
        helper.setTo("h.zhang@smail.nju.edu.cn");
        // 多附件
        helper.addAttachment("1.jpg", new File("/Users/zhao/Desktop/1.jpg"));
        helper.addAttachment("2.jpg", new File("/Users/zhao/Desktop/1.jpg"));
        mailSender.send(mimeMessage);

        return "mail2";
    }

}
