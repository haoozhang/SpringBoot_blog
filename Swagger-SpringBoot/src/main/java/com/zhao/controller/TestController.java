package com.zhao.controller;


import com.zhao.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api("接口测试类")
@RestController
public class TestController {

    @ApiOperation("hello 方法测试")
    @GetMapping("/hello")
    public String hello(@RequestParam @ApiParam("hello 方法参数") String param) {
        return "hello, " + param;
    }

    @ApiOperation("返回 User, 让 User 被 Swagger 捕获为 Model")
    @PostMapping("/user")
    public User user() {
        return new User();
    }
}
