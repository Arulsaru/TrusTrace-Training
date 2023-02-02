package com.socialmedia.instagram.pojo;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    private String userId;
    private String userName;
    private String bio;
    private Binary profilePicture;
    private long followersCount;
    private long followingCount;
    private long numberOfPosts;
    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.bio = "";
        this.followersCount = 0;
        this.followingCount = 0;
        this.numberOfPosts = 0;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public long getFollowersCount() { return followersCount; }
    public void setFollowersCount(long followersCount) { this.followersCount = followersCount; }
    public long getFollowingCount() { return followingCount; }
    public void setFollowingCount(long followingCount) { this.followingCount = followingCount; }
    public long getNumberOfPosts() { return numberOfPosts; }
    public void setNumberOfPosts(long numberOfPosts) { this.numberOfPosts = numberOfPosts; }
    public Binary getProfilePicture() { return profilePicture; }
    public void setProfilePicture(Binary profilePicture) { this.profilePicture = profilePicture; }
}
