package com.trustrace.service.employee;

import com.trustrace.pojo.Employee;
import com.trustrace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }
    public Employee getOneEmployee(String id) {
        return employeeRepository.getOneEmployee(id);
    }
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }
    public void delete(String id) {
        employeeRepository.delete(id);
    }
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }
    public List<Employee> getAllEmployeePaginated(String pageNumber, String pageSize) {
        return employeeRepository.getAllEmployeePaginated(pageNumber, pageSize);
    }
}
