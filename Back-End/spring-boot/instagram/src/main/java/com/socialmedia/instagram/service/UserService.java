package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.FollowUnfollowRepository;
import com.socialmedia.instagram.repository.UserRepository;
import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.service.validators.CreateUserValidator;
import com.socialmedia.instagram.service.validators.FollowUnfollowValidator;
import com.socialmedia.instagram.service.validators.IdNameAndEmailValidator;
import com.socialmedia.instagram.service.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    IdNameAndEmailValidator idNameAndEmailValidator;
    @Autowired
    CreateUserValidator createUserValidator;
    public User getUserById(String userId) throws Exception {
        idNameAndEmailValidator.preValidateUserId(userId);
        return userRepository.getUserById(userId);
    }
    public User getUserByName(String userName) throws Exception {
        idNameAndEmailValidator.preValidateUserName(userName);
        return userRepository.getUserByName(userName);
    }
    public List<User> getAllUser() {
        return userRepository.getAllUsers();
    }
    public void createUser(User user) throws Exception {
        createUserValidator.preValidateUser(user);
        userRepository.createUser(user);
    }
    public void editBio(String userId, String bio) throws Exception {
        idNameAndEmailValidator.isIdExist(userId);
        userRepository.editBio(userId, bio);
    }
    public void deleteUser(String userId) throws Exception {
        idNameAndEmailValidator.isIdExist(userId);
        userRepository.deleteUser(userId);
    }
}
