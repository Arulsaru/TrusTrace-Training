package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Like;
import com.socialmedia.instagram.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class LikeUnlikeRepository implements QueryImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    Update update;
    public void likePost(String userId, String postId) {
        update = new Update().inc("likeCount", 1);
        mongoTemplate.findAndModify(getQueryForPostId(postId), update, Post.class);
        update = new Update().push("likesList", userId);
        mongoTemplate.findAndModify(getQueryForPostId(postId), update, Like.class);
    }
    public void disLikePost(String userId, String postId) {
        update = new Update().inc("likeCount", -1);
        mongoTemplate.findAndModify(getQueryForPostId(postId), update, Post.class);
        update = new Update().pull("likesList", userId);
        mongoTemplate.findAndModify(getQueryForPostId(postId), update, Like.class);
    }
}
