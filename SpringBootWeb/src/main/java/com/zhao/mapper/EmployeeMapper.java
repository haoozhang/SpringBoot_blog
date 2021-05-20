package com.zhao.mapper;

import com.zhao.pojo.Department;
import com.zhao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeMapper {

    @Autowired
    private DepartmentMapper departmentMapper;

    // 暂时模拟数据库数据
    private static Map<Integer, Employee> employeeMap = null;
    static {
        employeeMap = new HashMap<>();
        employeeMap.put(1, new Employee(1, "aa", "aa@qq.com", 1, new Department(1, "教学部"), new Date()));
        employeeMap.put(2, new Employee(2, "bb", "bb@qq.com", 0, new Department(2, "科研部"), new Date()));
        employeeMap.put(3, new Employee(3, "cc", "cc@qq.com", 1, new Department(3, "市场部"), new Date()));
        employeeMap.put(4, new Employee(4, "dd", "dd@qq.com", 0, new Department(4, "后勤部"), new Date()));
        employeeMap.put(5, new Employee(5, "ee", "ee@qq.com", 1, new Department(5, "运营部"), new Date()));
    }

    // 数据库操作
    public Collection<Employee> selectAllEmployee() {
        return employeeMap.values();
    }

    public Employee selectEmployeeById(int id) {
        return employeeMap.get(id);
    }

    // 主键自增
    private static int initId = 6;

    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        // 传入的对象中只有 department 的 id
        Integer departmentId = employee.getDepartment().getDepartmentId();
        employee.setDepartment(departmentMapper.selectDepartmentById(departmentId));
        employeeMap.put(employee.getId(), employee);
    }

    public void deleteEmployee(int id) {
        employeeMap.remove(id);
    }
}
