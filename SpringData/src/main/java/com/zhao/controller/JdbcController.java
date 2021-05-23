package com.zhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询数据库所有信息
    @GetMapping("/listUser")
    public List<Map<String, Object>> listUser() {
        String sql = "select * from user";
        // List 中的一个 Map 对应一行数据，Map 的 key 为字段名，value 为具体值
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }

    // 添加用户
    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id, name, pwd) values (10, 'xiaoming', '12345678')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    // 更新用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update mybatis.user set name = ?, pwd = ? where id = " + id;
        Object[] objects = new Object[2];
        objects[0] = "xiaoming2";
        objects[1] = "4321";
        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    // 删除用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from mybatis.user where id = ?";
        jdbcTemplate.update(sql, id);
        return "delete-ok";
    }
}
