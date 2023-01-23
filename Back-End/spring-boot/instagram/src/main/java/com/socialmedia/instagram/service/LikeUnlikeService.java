package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.LikeUnlikeRepository;
import com.socialmedia.instagram.service.validators.IdAndNameValidator;
import com.socialmedia.instagram.service.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeUnlikeService {
    @Autowired
    LikeUnlikeRepository likeUnlikeRepository;
    @Autowired
    IdAndNameValidator idAndNameValidator;
    @Autowired
    PostValidator postValidator;
    public void likePost(String userId, String postId) throws Exception {
        idAndNameValidator.isIdExist(userId);
        postValidator.isPostExist(userId);
        likeUnlikeRepository.likePost(userId, postId);
    }
    public void disLikePost(String userId, String postId) throws Exception { // validator set pannanu
        idAndNameValidator.isNameExist(userId);
        postValidator.isPostExist(userId);
        likeUnlikeRepository.disLikePost(userId, postId);
    }
}
