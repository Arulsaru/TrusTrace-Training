package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.LikeUnlikeRepository;
import com.socialmedia.instagram.service.validators.IdNameAndEmailValidator;
import com.socialmedia.instagram.service.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeUnlikeService {
    @Autowired
    LikeUnlikeRepository likeUnlikeRepository;
    @Autowired
    IdNameAndEmailValidator idNameAndEmailValidator;
    @Autowired
    PostValidator postValidator;
    public void likePost(String userId, String postId) throws Exception {
        idNameAndEmailValidator.isIdExist(userId);
        postValidator.isPostExist(userId);
        likeUnlikeRepository.likePost(userId, postId);
    }
    public void disLikePost(String userId, String postId) throws Exception { // validator set pannanu
        idNameAndEmailValidator.isNameExist(userId);
        postValidator.isPostExist(userId);
        likeUnlikeRepository.disLikePost(userId, postId);
    }
}
