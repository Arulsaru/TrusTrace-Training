package com.socialmedia.instagram.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {
    @Id
    private long postId;
    private String imageUrl;
    private long likeCount;
    static int postIdCount = 0;
    public Post(String imageUrl) {
        this.postId = postIdCount + 1;
        this.imageUrl = imageUrl;
        this.likeCount = 0;
    }
    public long getPostId() { return postId; }
    public void setPostId(long postId) { this.postId = postId; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public long getLikeCount() { return likeCount; }
    public void setLikeCount(long likeCount) { this.likeCount = likeCount; }
}
