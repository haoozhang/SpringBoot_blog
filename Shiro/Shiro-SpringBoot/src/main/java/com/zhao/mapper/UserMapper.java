package com.zhao.mapper;

import com.zhao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper  // 表示这是一个 mybatis 的 mapper 类
public interface UserMapper {

    public User selectUserByName(String name);
}
