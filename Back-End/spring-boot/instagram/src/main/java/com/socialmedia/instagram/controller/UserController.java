package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.userservice.UserService;
import com.socialmedia.instagram.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/id/{userId}")
    public User getUserById(@PathVariable String userId) throws Exception {
        return userService.getUserById(userId);
    }
    @GetMapping("/name/{userName}")
    public User getUserByName(@PathVariable String userName) throws Exception {
        return userService.getUserByName(userName);
    }
    @PostMapping
    public String createUser(@RequestBody User user) throws Exception {
        userService.createUser(user);
        return "User with user-id " + user.getUserId() + " created";
    }
    @PutMapping("{userId}/follow/{userIdToFollow}")
    public String followUser(@PathVariable String userId, @PathVariable String userIdToFollow) throws Exception {
        userService.followUser(userId, userIdToFollow);
        return "Followed " + userIdToFollow;
    }
    @PutMapping("{userId}/unfollow/{userIdToUnfollow}")
    public String unfollowUser(@PathVariable String userId, @PathVariable String userIdToUnfollow) throws Exception {
        userService.unFollowUser(userId, userIdToUnfollow);
        return "Unfollowed " + userIdToUnfollow;
    }
}
