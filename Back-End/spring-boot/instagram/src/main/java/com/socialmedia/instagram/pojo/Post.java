package com.socialmedia.instagram.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "post")
public class Post {
    private String userId;
    @Id
    private String postId;
    private String imageUrl;
    private long likeCount;
    private Date uploadedDateAndTime;
    public Post(String userId, String imageUrl) {
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.likeCount = 0;
        this.uploadedDateAndTime = new Date();
    }
    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public long getLikeCount() { return likeCount; }
    public void setLikeCount(long likeCount) { this.likeCount = likeCount; }
}
