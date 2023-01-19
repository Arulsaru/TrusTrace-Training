package com.socialmedia.instagram.service.userservice.validators;

import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostValidator {
    @Autowired
    UserRepository userRepository;
    public void preValidatePost(String postId) throws Exception {
       if(isPostExist(postId)) {
           throw new Exception("Re - enter the post id correctly, Post id not found");
       }
    }
    public boolean isPostExist(String postId) {
        return userRepository.getPostById(postId) == null;
    }
}
