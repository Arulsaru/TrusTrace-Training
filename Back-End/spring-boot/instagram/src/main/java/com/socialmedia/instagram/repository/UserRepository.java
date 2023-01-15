package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    MongoTemplate mongoTemplate;
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
        User userObj;
        long count;

        userObj = getUserById(userId);
        count = userObj.getFollowersCount();
        count += 1; // incrementing followers count
        getUserById(userId).setFollowersCount(count);
        mongoTemplate.save(userObj);

        userObj = getUserById(userIdToFollow);
        count = userObj.getFollowingCount();
        count += 1; // incrementing following count
        getUserById(userId).setFollowingCount(count);
        mongoTemplate.save(userObj);
    }
    public void unfollowUser(String userId, String userIdToUnfollow) { // logic maathanu
        User userObj;
        long count;

        userObj = getUserById(userId);
        count = userObj.getFollowersCount();
        count -= 1; // decrementing followers count
        getUserById(userId).setFollowersCount(count);
        mongoTemplate.save(userObj);

        userObj = getUserById(userIdToUnfollow);
        count = userObj.getFollowingCount();
        count -= 1; // decrementing following count;
        getUserById(userId).setFollowingCount(count);
        mongoTemplate.save(userObj);
    }
    public void createPost(String userId, String imageUrl) {

    }
}
