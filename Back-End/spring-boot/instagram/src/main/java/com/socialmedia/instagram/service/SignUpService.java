package com.socialmedia.instagram.service;

import com.socialmedia.instagram.pojo.auth.SignUp;
import com.socialmedia.instagram.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;
    public void signUp(SignUp signUp) {
        signUpRepository.signUp(signUp);
    }
}
