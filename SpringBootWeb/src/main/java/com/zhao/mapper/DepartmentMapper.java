package com.zhao.mapper;

import com.zhao.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentMapper {

    // 暂时模拟数据库数据
    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<>();
        departmentMap.put(1, new Department(1, "教学部"));
        departmentMap.put(2, new Department(2, "科研部"));
        departmentMap.put(3, new Department(3, "市场部"));
        departmentMap.put(4, new Department(4, "后勤部"));
        departmentMap.put(5, new Department(5, "运营部"));
    }

    // 数据库操作
    public Collection<Department> selectAllDepartment() {
        return departmentMap.values();
    }

    public Department selectDepartmentById(int id) {
        return departmentMap.get(id);
    }
}
