package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    UserService userService;
    @PutMapping("{userId}/create/{imageUrl}")
    public String createPost(@PathVariable String userId, @PathVariable String imageUrl) throws Exception {
        userService.createPost(userId, imageUrl);
        return "Post created";
    }
    @GetMapping("{postId}")
    public Post getPostById(@PathVariable String postId) throws Exception {
        return userService.getPostById(postId);
    }
    @DeleteMapping("{userId}/delete/{postId}")
    public String deletePost(@PathVariable String userId, @PathVariable String postId) throws Exception {
        userService.deletePost(userId, postId);
        return "Post deleted";
    }
    @DeleteMapping("{userId}/deleteAll")
    public String deleteAllPostOfAUser(@PathVariable String userId) throws Exception {
        userService.deleteAllPostOfAUser(userId);
        return "The post in {userId} is deleted";
    }
    @PutMapping("like/{postId}")
    public String likePost(@PathVariable String postId) throws Exception {
        userService.likePost(postId);
        return "Liked post..!";
    }
}
