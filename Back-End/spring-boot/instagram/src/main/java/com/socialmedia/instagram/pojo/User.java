package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "instagram")
public class User {
    private String userId;
    private String userName;
    private long followersCount;
    private long followingCount;
    private List<Integer> postIds;
    private long totalNumberOfPosts;
    public User() {
        this.followersCount = 0;
        this.followingCount = 0;
        this.postIds = new ArrayList<>();
    }
    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
    public long getFollowersCount() { return followersCount; }
    public void setFollowersCount(long followersCount) { this.followersCount = followersCount; }
    public long getFollowingCount() { return followingCount; }
    public void setFollowingCount(long followingCount) { this.followingCount = followingCount; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public List<Integer> getPostIds() { return postIds; }
    public long getPostIdsSize() { return postIds.size(); }
    public void setPostId(Integer postId) { this.postIds.add(postId); }
    public long getTotalNumberOfPosts() { return totalNumberOfPosts; }
    public void setTotalNumberOfPosts(long totalNumberOfPosts) { this.totalNumberOfPosts = totalNumberOfPosts; }
}
