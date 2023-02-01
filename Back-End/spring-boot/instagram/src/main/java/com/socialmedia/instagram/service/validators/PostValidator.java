package com.socialmedia.instagram.service.validators;

import com.socialmedia.instagram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostValidator {
    @Autowired
    PostRepository postRepository;
    public void preValidatePost(String postId) throws Exception {
       if(isPostExist(postId)) {
           throw new Exception("Re - enter the post id correctly, Post id not found");
       }
    }
    public boolean isPostExist(String postId) {
        return postRepository.getPostById(postId) == null;
    }
}
