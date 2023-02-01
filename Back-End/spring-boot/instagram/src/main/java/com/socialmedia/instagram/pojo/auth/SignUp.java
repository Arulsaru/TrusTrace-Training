package com.socialmedia.instagram.pojo.auth;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="accounts")
public class SignUp {
    private String userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
//    private final Date accountCreatedDateAndTime;
//    private String userType;
//    private String alternateMobileNumber;
    public SignUp(String userId, String userName, String email, String phoneNumber, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
//        this.accountCreatedDateAndTime = new Date();
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
//    public Date getAccountCreatedDateAndTime() { return accountCreatedDateAndTime; }
}
