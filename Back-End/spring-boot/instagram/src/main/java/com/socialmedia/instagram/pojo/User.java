package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instagram")
public class User {
    private String userId;
    private String userName;
    private long FollowersCount;
    private long FollowingCount;
    public User() {
        this.FollowersCount = 0;
        this.FollowingCount = 0;
    }
    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
    public long getFollowersCount() { return FollowersCount; }
    public void setFollowersCount(long followersCount) { FollowersCount = followersCount; }
    public long getFollowingCount() { return FollowingCount; }
    public void setFollowingCount(long followingCount) { FollowingCount = followingCount; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
