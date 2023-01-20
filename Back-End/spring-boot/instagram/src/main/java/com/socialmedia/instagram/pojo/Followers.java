package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "followers")
public class Followers {
    private final String userId;
    private long followersCount;
    private List<String> followersList;
    public Followers(String userId) {
        this.userId = userId;
        this.followersCount = 0;
        this.followersList = new ArrayList<>();

    }
    public String getUserId() { return userId; }
    public long getFollowersCount() { return followersCount; }
    public void setFollowersCount(long followersCount) { this.followersCount = followersCount; }
    public List<String> getFollowersList() { return followersList; }
    public void setFollowersList(List<String> followersList) { this.followersList = followersList; }
}
