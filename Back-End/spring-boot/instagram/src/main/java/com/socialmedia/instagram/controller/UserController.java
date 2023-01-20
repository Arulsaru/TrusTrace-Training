package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.UserService;
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
    @DeleteMapping("id/{userId}")
    public String deleteUser(@PathVariable String userId) throws Exception {
        userService.deleteUser(userId);
        return "User deleted";
    }
}