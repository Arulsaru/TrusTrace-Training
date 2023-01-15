package com.socialmedia.instagram.service.userservice;

import com.socialmedia.instagram.repository.UserRepository;
import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.service.userservice.validators.CreateUserValidator;
import com.socialmedia.instagram.service.userservice.validators.FollowUserValidator;
import com.socialmedia.instagram.service.userservice.validators.UnFollowUserValidator;
import com.socialmedia.instagram.service.userservice.validators.IdAndNameValidator;
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
    FollowUserValidator followUserValidator;
    @Autowired
    UnFollowUserValidator unFollowUserValidator;
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
    public void followUser(String userId, String userIdToFollow) throws Exception {
        followUserValidator.preValidate(userId, userIdToFollow);
        userRepository.followUser(userId, userIdToFollow);
    }
    public void unFollowUser(String userId, String userIdToUnfollow) throws Exception {
        unFollowUserValidator.preValidate(userId, userIdToUnfollow);
        userRepository.unfollowUser(userId, userIdToUnfollow);
    }
}
