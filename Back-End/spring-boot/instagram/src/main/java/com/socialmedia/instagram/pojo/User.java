package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "instagram")
public class User {
    private String userId;
    private String userName;
    private List<String> postIds;
    private long totalNumberOfPosts;
    public User() {
        this.postIds = new ArrayList<>();
    }
    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public List<String> getPostIds() { return postIds; }
    public long getPostIdsSize() { return postIds.size(); }
    public void setPostId(String postId) { this.postIds.add(postId); }
    public long getTotalNumberOfPosts() { return totalNumberOfPosts; }
    public void setTotalNumberOfPosts(long totalNumberOfPosts) { this.totalNumberOfPosts = totalNumberOfPosts; }
}
