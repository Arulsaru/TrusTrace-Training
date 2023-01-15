package com.socialmedia.instagram.pojo;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Post {
    @Id
    private String postId;
    private String imageUrl;
    private long likeCount;
    public Post() {
        this.likeCount = 0;
    }
    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public long getLikeCount() { return likeCount; }
    public void setLikeCount(long likeCount) { this.likeCount = likeCount; }
}
