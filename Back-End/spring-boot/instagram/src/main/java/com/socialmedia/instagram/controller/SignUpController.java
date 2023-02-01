package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.pojo.auth.SignUp;
import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.service.SignUpService;
import com.socialmedia.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("signup")
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @Autowired
    UserService userService;
    @PostMapping
    public String signUp(@RequestBody SignUp signUp) throws Exception {
        userService.createUser(new User(signUp.getUserId(), signUp.getUserName()));
        signUpService.signUp(signUp);
        return "Redirect to login page..";
    }
}
