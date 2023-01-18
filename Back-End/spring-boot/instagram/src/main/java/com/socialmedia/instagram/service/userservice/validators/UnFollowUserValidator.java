package com.socialmedia.instagram.service.userservice.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnFollowUserValidator {
    @Autowired
    IdAndNameValidator idAndNameValidator;
    public void preValidate(String userId, String userIdToFollow) throws Exception {
        // yerkanave iruka nu paakanu
        idAndNameValidator.isIdExist(userId);
        idAndNameValidator.isIdExist(userIdToFollow);
    }
}
