package com.socialmedia.instagram.service.userservice.validators;

import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostValidator {
    @Autowired
    UserRepository userRepository;
    public void isPostExist(String userId, String postId) throws Exception {
        List<Integer> postIds = userRepository.getUserById(userId).getPostIds();
        if(!postIds.contains(Integer.parseInt(postId))) {
            throw new Exception("User with userId " + userId + " doesn't have the post - " + postId );
        }
    }
}
