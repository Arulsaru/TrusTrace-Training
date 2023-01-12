package com.trustrace.controller;

import com.trustrace.pojo.Employee;
import com.trustrace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @GetMapping
    public List<Employee> getAllEmployee() {
        return empService.getAllEmployee();
    }
    @GetMapping("/{employeeId}")
    public Employee getOneEmployeeById(@PathVariable String employeeId) throws Exception {
        return empService.getOneEmployee(employeeId);
    }
    @GetMapping("/getEmployeePaginated")
    public List<Employee> getEmployeesWithPagination(@RequestParam String pageNumber, @RequestParam String pageSize) {
        return empService.getAllEmployeePaginated(pageNumber, pageSize);
    }
    @PostMapping
    public String createEmployee(@RequestBody Employee newEmployee) throws Exception {
        empService.create(newEmployee);
        return "User created";
    }
    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployeeById(@PathVariable String employeeId) throws Exception {
        empService.delete(employeeId);
        return "User deleted";
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        empService.update(employee);
        return "User updated";
    }
}
