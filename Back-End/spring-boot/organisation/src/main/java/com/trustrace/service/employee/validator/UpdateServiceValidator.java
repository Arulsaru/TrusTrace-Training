package com.trustrace.service.employee.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceValidator {
    @Autowired
    CreateServiceValidator createServiceValidator;

}
