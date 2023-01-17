package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    private Query query;
    private Update update;
    public User getUserById(String userId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userId").is(userId)), User.class);
    }
    public User getUserByName(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), User.class);
    }
    public void createUser(User user) {
        mongoTemplate.save(user);
    }
    public void followUser(String userId, String userIdToFollow) {
        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        update = new Update().set("followingCount", getUserById(userId).getFollowingCount() + 1);
        mongoTemplate.findAndModify(query, update, User.class);

        query = new Query().addCriteria(Criteria.where("userId").is(userIdToFollow));
        update = new Update().set("followersCount", getUserById(userId).getFollowersCount() + 1);
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void unfollowUser(String userId, String userIdToUnfollow) { // logic maathanu

        // follow pannama unfollow kulla varatha maathiri logic eludhanu

        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        update = new Update().set("followingCount", getUserById(userId).getFollowingCount() - 1);
        mongoTemplate.findAndModify(query, update, User.class);

        query = new Query().addCriteria(Criteria.where("userId").is(userIdToUnfollow));
        update = new Update().set("followersCount", getUserById(userId).getFollowersCount() - 1);
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void createPost(String userId, String imageUrl) {
        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        Post post = new Post(imageUrl);
        getUserById(userId).setPost(post);
        update = new Update().set("post", getUserById(userId).getPost().add(post));
        mongoTemplate.findAndModify(query, update, User.class);
    }
}