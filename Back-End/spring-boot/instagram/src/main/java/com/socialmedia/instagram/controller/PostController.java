package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.postservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("{userId}/create/{imageUrl}")
    public String createPost(@PathVariable String userId ,@PathVariable String imageUrl) throws Exception {
        postService.createPost(userId, imageUrl);
        return "Post created";
    }
}
