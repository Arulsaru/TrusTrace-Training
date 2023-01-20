package com.socialmedia.instagram.service.validators;

import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdAndNameValidator {
    @Autowired
    UserRepository userRepository;
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
}
