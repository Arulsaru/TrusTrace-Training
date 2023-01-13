package com.trustrace.service.employee.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceValidator {
    @Autowired
    GetOneServiceValidator getOneServiceValidation;
    public void preValidate(String employeeId) throws Exception {
        getOneServiceValidation.isIdExist(employeeId);
    }
}


