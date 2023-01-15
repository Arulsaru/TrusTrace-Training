package com.socialmedia.instagram.service.userservice.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowUserValidator {
    @Autowired
    IdAndNameValidator idAndNameValidator;
    public void preValidate(String userId, String userIdToFollow) throws Exception {
        idAndNameValidator.isIdExist(userId);
        idAndNameValidator.isIdExist(userIdToFollow);
    }
}
