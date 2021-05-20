package com.zhao.controller;

import com.zhao.mapper.DepartmentMapper;
import com.zhao.mapper.EmployeeMapper;
import com.zhao.pojo.Department;
import com.zhao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/emps")
    public String listAllEmp(Model model) {
        Collection<Employee> employees = employeeMapper.selectAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/addEmp")
    public String toAdd(Model model) {
        // 查询部门信息
        Collection<Department> departments = departmentMapper.selectAllDepartment();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/addEmp")
    public String addEmp(Employee employee) {
        // 添加员工操作
        System.out.println("add--> " + employee);
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/updateEmp/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        // 查询原来的数据
        Employee employee = employeeMapper.selectEmployeeById(id);
        model.addAttribute("emp", employee);
        // 查询部门信息
        Collection<Department> departments = departmentMapper.selectAllDepartment();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        System.out.println("update--> " + employee);
        // 更新员工操作
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }
}
