package com.trustrace.service;

import com.trustrace.pojo.Employee;
import com.trustrace.repository.EmployeeRepository;
import com.trustrace.service.validation.CreateServiceValidation;
import com.trustrace.service.validation.DeleteServiceValidation;
import com.trustrace.service.validation.GetOneServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GetOneServiceValidation getOneServiceValidation;
    @Autowired
    private CreateServiceValidation createServiceValidation;
    @Autowired
    private DeleteServiceValidation deleteServiceValidation;
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }
    public Employee getOneEmployee(String employeeId) throws Exception {
        getOneServiceValidation.isIdExist(employeeId);
        return employeeRepository.getOneEmployee(employeeId);
    }
    public void create(Employee employee) throws Exception {
        createServiceValidation.preValidate(employee);
        employeeRepository.create(employee);
    }
    public void delete(String employeeId) throws Exception {
        deleteServiceValidation.preValidate(employeeId);
        employeeRepository.delete(employeeId);
    }
    public void update(Employee employee) {
        employeeRepository.update(employee);  // remove pannanu
    }
    public List<Employee> getAllEmployeePaginated(String pageNumber, String pageSize) {
        return employeeRepository.getAllEmployeePaginated(pageNumber, pageSize);
    }
}
