package com.socialmedia.instagram.service;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.repository.PostRepository;
import com.socialmedia.instagram.service.validators.IdAndNameValidator;
import com.socialmedia.instagram.service.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IdAndNameValidator idAndNameValidator;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostValidator postValidator;
    public void createPost(String userId,String imageUrl) throws Exception {
        idAndNameValidator.isIdExist(userId);
        postRepository.createPost(userId, imageUrl);
    }
    public Post getPostById(String postId) throws Exception {
        postValidator.isPostExist(postId);
        return postRepository.getPostById(postId);
    }
    public void deletePost(String postId) throws Exception {
        postValidator.preValidatePost(postId);
        postRepository.deletePost(postId);
    }
    public void deleteAllPostOfAUser(String userId) throws Exception {
        idAndNameValidator.isIdExist(userId);
        postRepository.deleteAllPostOfAUser(userId);
    }
    public List<Post> getAllPost(String pageNumber, String pageSize) { return postRepository.getAllPost(pageNumber, pageSize); }
    public List<Post> getAllPostOfAUser(String userId, String pageNumber, String pageSize) {
        return postRepository.getAllPostOfAUser(userId, pageNumber, pageSize);
    }
}
