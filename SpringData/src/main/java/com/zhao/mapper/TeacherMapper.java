package com.zhao.mapper;

import com.zhao.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  // 表示这是一个 Mybatis 的 mapper 类
@Repository
public interface TeacherMapper {

    List<Teacher> selectAllTeacher();

    Teacher selectTeacherById(int id);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacher(int id);
}
