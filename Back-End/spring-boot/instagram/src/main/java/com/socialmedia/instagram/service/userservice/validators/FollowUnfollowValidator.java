package com.socialmedia.instagram.service.userservice.validators;

import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FollowUserValidator {
    @Autowired
    IdAndNameValidator idAndNameValidator;
    @Autowired
    UserRepository userRepository;
    public void preValidate(String userId, String userIdToFollow) throws Exception {
        idAndNameValidator.isIdExist(userId);
        idAndNameValidator.isIdExist(userIdToFollow);

        if(isBothIdEqual(userId, userIdToFollow)) {
            throw new Exception("Both id are same");
        }

        if(isAlreadyFollowed(userId, userIdToFollow)) {
            throw new Exception(userId + " is already following " + userIdToFollow);
        }
    }
    private boolean isAlreadyFollowed(String userId, String userIdToFollow) {
        return userRepository.getUserById(userId)
                             .getFollowingList()
                             .contains(userIdToFollow);
    }
}
