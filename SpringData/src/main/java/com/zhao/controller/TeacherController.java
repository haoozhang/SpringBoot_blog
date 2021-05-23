package com.zhao.controller;

import com.zhao.mapper.TeacherMapper;
import com.zhao.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/listTeacher")
    public List<Teacher> listTeacher() {
        return teacherMapper.selectAllTeacher();
    }

    @GetMapping("/listTeacher/{id}")
    Teacher selectUserById(@PathVariable int id) {
        return teacherMapper.selectTeacherById(id);
    }

    @GetMapping("addTeacher")
    int addTeacher() {
        Teacher teacher = new Teacher(2, "zhanghao");
        return teacherMapper.addTeacher(teacher);
    }

    @GetMapping("updateTeacher")
    int updateTeacher() {
        Teacher teacher = new Teacher(2, "张老师");
        return teacherMapper.updateTeacher(teacher);
    }

    @GetMapping("/deleteTeacher/{id}")
    int deleteTeacher(@PathVariable int id) {
        return teacherMapper.deleteTeacher(id);
    }

}
