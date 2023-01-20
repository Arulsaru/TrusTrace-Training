package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "following")
public class Following {
    private final String userId;
    private long followingCount;
    private List<String> followingList;
    public Following(String userId) {
        this.userId = userId;
        this.followingCount = 0;
        this.followingList = new ArrayList<>();
    }
    public String getUserId() { return userId; }
    public long getFollowingCount() { return followingCount; }
    public void setFollowingCount(long followingCount) { this.followingCount = followingCount; }
    public List<String> getFollowingList() { return followingList; }
    public void setFollowingList(List<String> followingList) { this.followingList = followingList; }
}
