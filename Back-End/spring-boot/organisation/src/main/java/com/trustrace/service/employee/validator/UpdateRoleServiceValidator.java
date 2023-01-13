package com.trustrace.service.employee.validator;

import com.trustrace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRoleServiceValidator {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GetOneServiceValidator getOneServiceValidation;
    public void preValidate(String employeeId, String role) throws Exception {
        getOneServiceValidation.isIdExist(employeeId);
        if(isRoleExistInOrganisation(role)) {
            throw new Exception("Try entering the correct role..");
        }
        employeeRepository.updateRole(employeeId, role);
    }
    public boolean isRoleExistInOrganisation(String role) {
        return employeeRepository.roles.contains(role);
    }
}
