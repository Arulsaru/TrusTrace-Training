package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
