package com.trustrace.service.validation;

import com.trustrace.pojo.Employee;
import com.trustrace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOneServiceValidation {
    @Autowired
    EmployeeRepository employeeRepository;
    public void isIdExist(String id) throws Exception {
        Optional<Employee> optionalEmployeeObject = employeeRepository.getAllEmployee().stream()
                                                                                        .filter(employee -> employee.getEmployeeId()
                                                                                        .equals(id))
                                                                                        .findFirst();
        if(optionalEmployeeObject.isEmpty()) {
            throw new Exception("Employee with employee id " + optionalEmployeeObject.get().getEmployeeId() + " not found");
        }
    }
}
