package com.socialmedia.instagram.service.userservice.validators;

import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserValidator {
    @Autowired
    UserRepository userRepository;
    public void preValidateUser(User user) throws Exception {
        if(isIdAvailable(user.getUserId())) {
            throw new Exception("User with instagram id " + user.getUserId() + " already exists");
        } else if(isNameAvailable(user.getUserName())) {
            throw new Exception("User with instagram id " + user.getUserName() + " already exists");
        }
    }
    public Boolean isIdAvailable(String userId) { return (userRepository.getUserById(userId) != null); }
    public Boolean isNameAvailable(String userName) { return (userRepository.getUserByName(userName) != null); }
}
