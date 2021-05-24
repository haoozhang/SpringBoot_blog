package com.zhao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteController {

    @GetMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/toLogin"})
    public String toLogin() {
        return "views/login";
    }

    @GetMapping("/level1/{idx}")
    public String level1(@PathVariable("idx") int idx) {
        return "views/level1/" + idx;
    }

    @GetMapping("/level2/{idx}")
    public String level2(@PathVariable("idx") int idx) {
        return "views/level2/" + idx;
    }

    @GetMapping("/level3/{idx}")
    public String level3(@PathVariable("idx") int idx) {
        return "views/level3/" + idx;
    }

}
