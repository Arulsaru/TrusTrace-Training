package com.socialmedia.instagram.service.validators;

import com.socialmedia.instagram.repository.SignUpRepository;
import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdNameAndEmailValidator {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SignUpRepository signUpRepository;
    public void preValidateUserId(String userId) throws Exception {
        isIdExist(userId);
    }
    public void preValidateUserName(String userName) throws Exception {
        isNameExist(userName);
    }
    public void isIdExist(String userId) throws Exception {
        if (userRepository.getUserById(userId) == null) {
            throw new Exception("User with id " + userId + " is not found");
        }
    }
    public void isNameExist(String userName) throws Exception {
        if(userRepository.getUserByName(userName) == null) {
            throw new Exception("User with user name " + userName + " is not found");
        }
    }
    public void isEmailExist(String email) throws Exception {
        if(signUpRepository.getUserByEmail(email) == null) {
            throw new Exception("User with email " + email + " is not found");
        }
    }
}
