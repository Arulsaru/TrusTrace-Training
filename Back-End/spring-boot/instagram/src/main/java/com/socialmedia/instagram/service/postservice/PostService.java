package com.socialmedia.instagram.service.postservice;

import com.socialmedia.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    UserRepository userRepository;
    public void createPost(String userId,String imageUrl) throws Exception {
        userRepository.createPost(userId, imageUrl);
    }
}
