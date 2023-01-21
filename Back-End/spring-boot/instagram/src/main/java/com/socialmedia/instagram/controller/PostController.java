package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
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
    @DeleteMapping("delete/{postId}")
    public String deletePost(@PathVariable String postId) throws Exception {
        postService.deletePost(postId);
        return "Post deleted";
    }
    @DeleteMapping("{userId}/deleteAll")
    public String deleteAllPostOfAUser(@PathVariable String userId) throws Exception {
        postService.deleteAllPostOfAUser(userId);
        return "All post in userId - " + userId + " is deleted";
    }
}
