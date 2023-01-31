package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.LoginRepository;
import com.socialmedia.instagram.service.validators.IdAndNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    IdAndNameValidator idAndNameValidator;
    public void login(String userId, String password) throws Exception {
        idAndNameValidator.isIdExist(userId);
        if(! password.equals(loginRepository.login(userId, password))) {
            throw new Exception("Invalid Password");
        }
    }
}
