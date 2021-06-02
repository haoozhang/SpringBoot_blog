package com.zhao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", "Hello, Shiro");
        return "index";
    }

    @GetMapping("/user/add")
    public String add() {
        return "/user/add";
    }

    @GetMapping("/user/update")
    public String update() {
        return "/user/update";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/login")
    public String login(String username, String password, Model model) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行登录方法，若没有异常就登录成功
        try {
            subject.login(token); // login 方法中调用了 Realm 的 doGetAuthenticationInfo 方法
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @ResponseBody
    @GetMapping("/noauth")
    public String unAuthorized() {
        return "Not Authorized!";
    }
}
