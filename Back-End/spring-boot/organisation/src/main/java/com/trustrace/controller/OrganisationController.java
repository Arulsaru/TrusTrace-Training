package com.trustrace.controller;

import com.trustrace.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("organisation")
public class OrganisationController {
    @Autowired
    EmployeeService employeeService;
    @PutMapping("/updateRole")
    public String updateRole(@RequestParam String employeeId ,@RequestParam String role) throws Exception {
        employeeService.updateRole(employeeId, role);
        return "Role Updated";
    }
    @PutMapping("/addNewRole")
    public String addNewRole() {
        return "Added new role into the list";
    }
}
