package com.socialmedia.instagram.controller.auth;

import com.socialmedia.instagram.dto.AuthRequest;
import com.socialmedia.instagram.pojo.auth.Login;
import com.socialmedia.instagram.service.JwtService;
import com.socialmedia.instagram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping
    public String login(@RequestBody Login loginRequest) throws Exception {
        loginService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return "Logged in successfully";
    }
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUserName());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
//        return jwtService.generateToken(authRequest.getUserName()); // generate token for each and every user
    }
}
