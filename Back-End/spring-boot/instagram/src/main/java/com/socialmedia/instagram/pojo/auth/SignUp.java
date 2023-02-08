package com.socialmedia.instagram.pojo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document(collection="accounts")
public class SignUp {
    @Autowired
    PasswordEncoder passwordEncoder;
    private String userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String roles;
    public SignUp(String userId, String userName, String email, String phoneNumber, String password, String roles) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
    }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRoles() { return roles; }
    public void setRoles(String roles) { this.roles = roles; }
}
