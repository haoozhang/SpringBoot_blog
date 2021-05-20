package com.zhao.pojo;

import com.zhao.pojo.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer gender;  // female: 0, male: 1
    private Department department;
    private Date birth;
}
