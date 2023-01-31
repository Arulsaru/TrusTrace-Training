package com.socialmedia.instagram.pojo.auth;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public class Login {
    private final String userId;
    private final String password;
    private final Date loggedInDate;
    public Login(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.loggedInDate = new Date();
    }
    public String getUserId() { return userId; }
    public String getPassword() { return password; }
    public Date getLoggedInDate() { return loggedInDate; }
}
