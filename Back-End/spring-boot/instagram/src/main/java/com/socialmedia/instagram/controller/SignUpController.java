package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.pojo.auth.SignUp;
import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.service.SignUpService;
import com.socialmedia.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @Autowired
    UserService userService;
    @PostMapping
    public String signUp(@RequestBody SignUp signUp) throws Exception {
        signUpService.signUp(signUp);
        userService.createUser(new User(signUp.getUserId(), signUp.getUserName()));
        return "Redirect to login page..";
    }
}
