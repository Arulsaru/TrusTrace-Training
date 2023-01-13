package com.trustrace.service.employee.validator;

import com.trustrace.pojo.Employee;
import com.trustrace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateServiceValidator {
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
        Employee optionalEmployeeObject = employeeRepository.getOneEmployee(employeeId);
        return (optionalEmployeeObject != null);
    }
    public boolean isEmailExist(Employee employee) {
        return employeeRepository.getOneEmployee(employee.getEmployeeId()) // logic thappu
                                    .getEmail()
                                    .equals(employee.getEmail());
    }
    public boolean isPhoneNumberExist(Employee employee) {
        return employeeRepository.getOneEmployee(employee.getEmployeeId()) //logic thappu
                                    .getPhoneNumber()
                                    .equals(employee.getPhoneNumber());
    }
    public boolean hasTenDigits(String number) {
        return (number.length() != 10);
    }
}
