package com.socialmedia.instagram.controller.auth;

import com.socialmedia.instagram.pojo.auth.Login;
import com.socialmedia.instagram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @GetMapping
    public String login(@RequestBody Login loginRequest) throws Exception {
        loginService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return "Logged in successfully";
    }
}
