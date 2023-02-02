package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.FollowUnfollowRepository;
import com.socialmedia.instagram.repository.UserRepository;
import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.service.validators.CreateUserValidator;
import com.socialmedia.instagram.service.validators.FollowUnfollowValidator;
import com.socialmedia.instagram.service.validators.IdNameAndEmailValidator;
import com.socialmedia.instagram.service.validators.PostValidator;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public void updateProfilePicture(String userId, MultipartFile multipartFile) throws Exception{
        userRepository.updateProfilePicture(userId, multipartFile);
    }
    public Binary getProfilePicture(String userId) throws Exception {
        Binary obj = userRepository.getProfilePicture(userId);
        System.out.println(obj);
        if(obj == null) {
            throw new Exception("Profile picture is empty... try updating profile picture");
        }
        return obj;
    }
}
