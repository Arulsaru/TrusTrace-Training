package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "instagram")
public class User {
    private String userId;
    private String userName;
    private long followersCount;
    private long followingCount;
    private ArrayList<Post> post;
    public User() {
        this.followersCount = 0;
        this.followingCount = 0;
        this.post = new ArrayList<>();
    }
    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
    public long getFollowersCount() { return followersCount; }
    public void setFollowersCount(long followersCount) { followersCount = followersCount; }
    public long getFollowingCount() { return followingCount; }
    public void setFollowingCount(long followingCount) { this.followingCount = followingCount; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public ArrayList<Post> getPost() { return post; }
    public void setPost(Post post) {
        this.post.add(post);
    }
}
