package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    public void login(String email, String password) throws Exception {
        if(! password.equals(loginRepository.login(email))) {
            throw new Exception("Invalid Password");
        }
    }
}
