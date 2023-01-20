package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.service.PostService;
import com.socialmedia.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @PutMapping("{userId}/create/{imageUrl}")
    public String createPost(@PathVariable String userId, @PathVariable String imageUrl) throws Exception {
        postService.createPost(userId, imageUrl);
        return "Post created";
    }
    @GetMapping("{postId}")
    public Post getPostById(@PathVariable String postId) throws Exception {
        return postService.getPostById(postId);
    }
    @GetMapping("getAllPost")
    public List<Post> getAllPost(@RequestParam String pageNumber,@RequestParam String pageSize) throws Exception {
        return postService.getAllPost(pageNumber, pageSize);
    }
    @GetMapping("{userId}/getAllPost")
    public List<Post> getAllPostOfAUser(@PathVariable String userId, @RequestParam String pageNumber, @RequestParam String pageSize) throws Exception {
        return postService.getAllPostOfAUser(userId, pageNumber, pageSize);
    }
    @DeleteMapping("{userId}/delete/{postId}")
    public String deletePost(@PathVariable String userId, @PathVariable String postId) throws Exception {
        postService.deletePost(userId, postId);
        return "Post deleted";
    }
    @DeleteMapping("{userId}/deleteAll")
    public String deleteAllPostOfAUser(@PathVariable String userId) throws Exception {
        postService.deleteAllPostOfAUser(userId);
        return "The post in {userId} is deleted";
    }
    @PutMapping("like/{postId}")
    public String likePost(@PathVariable String postId) throws Exception {
        postService.likePost(postId);
        return "Liked post..!";
    }
}
