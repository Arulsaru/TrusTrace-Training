package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.LoginRepository;
import com.socialmedia.instagram.repository.QueryImpl;
import com.socialmedia.instagram.service.validators.IdNameAndEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    IdNameAndEmailValidator idNameAndEmailValidator;
    public void login(String email, String password) throws Exception {
        idNameAndEmailValidator.isEmailExist(email);
        if(! password.equals(loginRepository.login(email))) {
            throw new Exception("Invalid Password");
        }
    }
}
