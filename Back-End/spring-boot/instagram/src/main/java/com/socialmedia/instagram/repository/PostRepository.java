package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository implements QueryImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    public void createPost(String userId, String imageUrl) {
        mongoTemplate.save(new Post(userId, imageUrl)); // creating new post
    }
    public Post getPostById(String postId) {
        return mongoTemplate.findOne(getQueryForPostId(postId), Post.class);
    }
    public List<Post> getAllPost(String pageNumber, String pageSize) {
        return mongoTemplate.find(
                new Query().skip((long) Integer.parseInt(pageNumber) * Integer.parseInt(pageSize))
                           .limit(Integer.parseInt(pageSize)), Post.class);
    }
    public List<Post> getAllPostOfAUser(String userId, String pageNumber, String pageSize) {
        return mongoTemplate.find(getQueryForPostId(userId)
                            .skip( (long) Integer.parseInt(pageNumber) * Integer.parseInt(pageSize))
                            .limit(Integer.parseInt(pageSize)), Post.class);
    }
    public void deleteAllPostOfAUser(String userId) {
        mongoTemplate.remove(getQueryForUserId(userId), Post.class);
    }
    public void deletePost(String postId) {
        mongoTemplate.remove(getQueryForPostId(postId), Post.class);
    }
}
