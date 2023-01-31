package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    private String userId;
    private String userName;
    private long followersCount;
    private long followingCount;
    private long numberOfPosts;
    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = 0;
        this.followingCount = 0;
        this.numberOfPosts = 0;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public long getFollowersCount() { return followersCount; }
    public void setFollowersCount(long followersCount) { this.followersCount = followersCount; }
    public long getFollowingCount() { return followingCount; }
    public void setFollowingCount(long followingCount) { this.followingCount = followingCount; }
    public long getNumberOfPosts() { return numberOfPosts; }
    public void setNumberOfPosts(long numberOfPosts) { this.numberOfPosts = numberOfPosts; }
}
