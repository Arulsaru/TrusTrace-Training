package com.trustrace.service.validation;

import com.trustrace.service.validation.CreateServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateServiceValidation {
    @Autowired
    CreateServiceValidation createServiceValidation;

}
