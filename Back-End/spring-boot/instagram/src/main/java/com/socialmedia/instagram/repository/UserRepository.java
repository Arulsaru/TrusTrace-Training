package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Followers;
import com.socialmedia.instagram.pojo.Following;
import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepository implements QueryImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    public User getUserById(String userId) {
        return mongoTemplate.findOne(getQueryForUserId(userId), User.class);
    }
    public User getUserByName(String userName) {
        return mongoTemplate.findOne(getQueryForUserName(userName), User.class);
    }
    public void createUser(User user) {
        mongoTemplate.save(user);
        mongoTemplate.save(new Following(user.getUserId()));
        mongoTemplate.save(new Followers(user.getUserId()));
    }
    public void deleteUser(String userId) {
        Query query = getQueryForUserId(userId);
        mongoTemplate.remove(query, User.class);
        mongoTemplate.remove(query, Post.class);
        mongoTemplate.remove(query, Following.class);
        mongoTemplate.remove(query, Followers.class);
    }
}