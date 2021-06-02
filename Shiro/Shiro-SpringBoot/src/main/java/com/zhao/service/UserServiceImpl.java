package com.zhao.service;

import com.zhao.mapper.UserMapper;
import com.zhao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserMapper {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }
}
