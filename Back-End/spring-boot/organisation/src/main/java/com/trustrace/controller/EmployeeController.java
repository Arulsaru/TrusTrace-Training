package com.trustrace.controller;

import com.trustrace.Employee;
import com.trustrace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @GetMapping("/allEmployee")
    public List<Employee> getAllEmployee() {
        return empService.getAllEmployee();
    }
    @GetMapping("/emp/{employeeId}")
    public Employee getOneEmployeeById(@PathVariable String employeeId) {
        return empService.getOneEmployee(employeeId);
    }
    @GetMapping("/getPaginated")
        public List<Employee> getEmployeesWithPagination(@RequestParam String pageNumber, @RequestParam String pageSize) {
        return empService.getAllEmployeePaginated(pageNumber, pageSize);
    }
    @PostMapping
    public String createEmployee(@RequestBody Employee newEmployee) {
        empService.create(newEmployee);
        return "User created";
    }
    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployeeById(@PathVariable String employeeId) {
        empService.delete(employeeId);
        return "User deleted";
    }
    @PutMapping("/update")
        public String updateEmployee(@RequestBody Employee employee) {
        empService.update(employee);
        return "User updated";
    }
}
