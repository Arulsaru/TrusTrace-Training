package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.FollowUnfollowUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FollowUnfollowController {
    @Autowired
    FollowUnfollowUserService followUnfollowUserService;
    @PutMapping("{userId}/follow/{userIdToFollow}")
    public String followUser(@PathVariable String userId, @PathVariable String userIdToFollow) throws Exception {
        followUnfollowUserService.followUser(userId, userIdToFollow);
        return "Followed " + userIdToFollow;
    }
    @PutMapping("{userId}/unfollow/{userIdToUnfollow}")
    public String unfollowUser(@PathVariable String userId, @PathVariable String userIdToUnfollow) throws Exception {
        followUnfollowUserService.unFollowUser(userId, userIdToUnfollow);
        return "Unfollowed " + userIdToUnfollow;
    }
}
