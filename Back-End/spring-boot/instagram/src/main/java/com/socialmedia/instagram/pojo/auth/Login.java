package com.socialmedia.instagram.pojo.auth;

import java.util.Date;

public class Login {
    private final String email;
    private final String password;
    private final Date loggedInDate;
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
        this.loggedInDate = new Date();
    }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Date getLoggedInDate() { return loggedInDate; }
}
