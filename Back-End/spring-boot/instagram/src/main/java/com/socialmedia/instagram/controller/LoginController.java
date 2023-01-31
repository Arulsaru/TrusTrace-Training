package com.socialmedia.instagram.controller;

import com.socialmedia.instagram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;
    public void login(@PathVariable String userId, @PathVariable String password) throws Exception {
        loginService.login(userId, password);
    }
}
