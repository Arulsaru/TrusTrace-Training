package com.trustrace.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceValidation {
    @Autowired
    GetOneServiceValidation getOneServiceValidation;
    public void preValidate(String employeeId) throws Exception {
        getOneServiceValidation.isIdExist(employeeId);
    }
}


