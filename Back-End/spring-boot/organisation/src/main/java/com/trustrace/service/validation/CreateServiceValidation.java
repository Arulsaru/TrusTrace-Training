package com.trustrace.service.validation;

import com.trustrace.pojo.Employee;
import com.trustrace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreateServiceValidation {
    @Autowired
    private EmployeeRepository employeeRepository;
    public void preValidate(Employee employee) throws Exception {
        if(isIdExist(employee.getEmployeeId())) {
            throw new Exception("Employee id is already in use");
        }

        // comes only when it is a new employee ilana mela exception oda stop aagidum
        if(isEmailExist(employee)) {
            throw new Exception("User with email id " + employee.getEmail() + " already exists");
        }
        if(isPhoneNumberExist(employee)) {
            throw new Exception("User with phone number " + employee.getPhoneNumber() + " already exists");
        }
        if(hasTenDigits(employee.getPhoneNumber())) {
            throw new Exception("Phone number should be of 10 digits...");
        }
    }
    public boolean isIdExist(String employeeId) throws Exception {
        Optional<Employee> optionalEmployeeObject = employeeRepository.getAllEmployee().stream()
                                                                                        .filter(employee -> employee.getEmployeeId()
                                                                                        .equals(employeeId))
                                                                                        .findFirst();
        return optionalEmployeeObject.isPresent();
    }

    public boolean isEmailExist(Employee employee) {
        return employeeRepository.getAllEmployee().stream()
                .anyMatch(emp -> emp.getEmail()
                        .equals(employee.getEmail()));
    }
    public boolean isPhoneNumberExist(Employee employee) {
        return employeeRepository.getAllEmployee().stream()
                .anyMatch(emp -> emp.getPhoneNumber()
                        .equals(employee.getPhoneNumber()));
    }
    public boolean hasTenDigits(String number) {
        return (number.length() != 10);
    }
}
