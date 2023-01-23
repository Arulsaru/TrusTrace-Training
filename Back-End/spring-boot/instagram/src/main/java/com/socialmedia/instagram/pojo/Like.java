package com.socialmedia.instagram.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "like")
public class Like {
    private String postId;
    private List<String> likesList;
    public Like(String postId) {
        this.postId = postId;
        likesList = new ArrayList<>();
    }
    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }
    public List<String> getLikesList() { return likesList; }
    public void setLikesList(List<String> likesList) { this.likesList = likesList; }
}
