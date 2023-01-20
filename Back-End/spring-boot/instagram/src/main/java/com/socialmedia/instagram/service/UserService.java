package com.socialmedia.instagram.service;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.repository.FollowUnfollowRepository;
import com.socialmedia.instagram.repository.UserRepository;
import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.service.validators.CreateUserValidator;
import com.socialmedia.instagram.service.validators.FollowUnfollowValidator;
import com.socialmedia.instagram.service.validators.IdAndNameValidator;
import com.socialmedia.instagram.service.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    IdAndNameValidator idAndNameValidator;
    @Autowired
    CreateUserValidator createUserValidator;
    @Autowired
    FollowUnfollowValidator followUnfollowValidator;
    @Autowired
    FollowUnfollowRepository followUnfollowRepository;
    @Autowired
    PostValidator postValidator;
    public User getUserById(String userId) throws Exception {
        idAndNameValidator.preValidateUserId(userId);
        return userRepository.getUserById(userId);
    }
    public User getUserByName(String userName) throws Exception {
        idAndNameValidator.preValidateUserName(userName);
        return userRepository.getUserByName(userName);
    }
    public void createUser(User user) throws Exception {
        createUserValidator.preValidateUser(user);
        userRepository.createUser(user);
    }
    public void deleteUser(String userId) throws Exception {
        idAndNameValidator.isIdExist(userId);
        userRepository.deleteUser(userId);
    }
}
