package com.zhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("loginUsername", username);
            // 登录成功，跳转到主界面
            return "redirect:main.html";
        } else {
            // 登录失败，回传错误信息
            model.addAttribute("msg", "用户名或密码有误");
            return "index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
