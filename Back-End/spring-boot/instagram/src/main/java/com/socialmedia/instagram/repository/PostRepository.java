package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserRepository userRepository;
    Query query;
    Update update;
    public void createPost(String userId, String imageUrl) {
        mongoTemplate.save(new Post(userId, imageUrl)); // creating new post
    }
    public Post getPostById(String postId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("postId").is(postId)), Post.class);
    }
    public List<Post> getAllPost(String pageNumber, String pageSize) {
        return mongoTemplate.find(
                new Query().skip((long) Integer.parseInt(pageNumber) * Integer.parseInt(pageSize))
                           .limit(Integer.parseInt(pageSize)), Post.class);
    }
    public List<Post> getAllPostOfAUser(String userId, String pageNumber, String pageSize) {
        return mongoTemplate.find(
                Query.query(Criteria.where("userId").is(userId))
                        .skip( (long) Integer.parseInt(pageNumber) * Integer.parseInt(pageSize))
                        .limit(Integer.parseInt(pageSize)), Post.class);
    }
    public void deleteAllPostOfAUser(String userId) {
        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, Post.class);
    }
    public void deletePost(String userId, String postId) {
        mongoTemplate.remove(Query.query(Criteria.where("postId").is(postId)), Post.class);
    }
    public void likePost(String postId) {
        update = new Update();
        update.inc("likeCount");
        mongoTemplate.findAndModify(Query.query(Criteria.where("postId").is(postId)), update, Post.class);
    }
}
