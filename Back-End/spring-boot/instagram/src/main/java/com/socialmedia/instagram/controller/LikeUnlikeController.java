package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.LikeUnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LikeUnlikeController {
    @Autowired
    LikeUnlikeService likeUnlikeService;

    @GetMapping("like{userId}{postId}")
    public String likePost(@PathVariable String userId, @PathVariable String postId) throws Exception {
        likeUnlikeService.likePost(userId, postId);
        return "Post Liked";
    }
    @GetMapping("dislike{userId}{postId}")
    public String disLikePost(@PathVariable String userId, @PathVariable String postId) throws Exception {
        likeUnlikeService.disLikePost(userId, postId);
        return "Post Liked";
    }

}
