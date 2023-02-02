package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.UserService;
import com.socialmedia.instagram.pojo.User;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("user")
//@CrossOrigin("*")      // for cors policy
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
    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }
    @PutMapping("{userId}/editBio/{bio}")
    public String editBio(@PathVariable String userId, @PathVariable String bio) throws Exception {
        userService.editBio(userId, bio);
        return "The altered bio is " + bio;
    }
    @PostMapping("{userId}/uploadImage")
    public void updateProfilePicture(@PathVariable String userId, @RequestParam("file") MultipartFile multipartFile) throws Exception {
        userService.updateProfilePicture(userId, multipartFile);
    }
    @GetMapping("{userId}/getImage")
    public Binary getProfilePicture(@PathVariable String userId) throws Exception {
        return userService.getProfilePicture(userId);
    }
    @DeleteMapping("id/{userId}")
    public String deleteUser(@PathVariable String userId) throws Exception {
        userService.deleteUser(userId);
        return "User deleted";
    }
}