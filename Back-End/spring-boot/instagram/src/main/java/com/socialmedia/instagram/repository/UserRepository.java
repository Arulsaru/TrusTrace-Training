package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Followers;
import com.socialmedia.instagram.pojo.Following;
import com.socialmedia.instagram.pojo.Post;
import com.socialmedia.instagram.pojo.User;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
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
    public void updateFollowerCount(String userId, int incrementFactor) {
        mongoTemplate.findAndModify(getQueryForUserId(userId),
                                    new Update().inc("followersCount", incrementFactor),
                                    User.class);
    }
    public void updateFollowingCount(String userId, int incrementFactor) {
        mongoTemplate.findAndModify(getQueryForUserId(userId),
                                    new Update().inc("followingCount", incrementFactor),
                                    User.class);
    }
    public void editBio(String userId, String bio) {
        mongoTemplate.findAndModify(getQueryForUserId(userId), new Update().set("bio", bio), User.class);
    }
    public void updateProfilePicture(String userId, MultipartFile multipartFile) throws Exception {
        Update update = new Update();
        update.set( "profilePicture" ,new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));
        mongoTemplate.findAndModify(getQueryForUserId(userId), update, User.class);
    }
    public Binary getProfilePicture(String userId) {
        System.out.println(getUserById(userId));
        System.out.println(userId);
        return getUserById(userId).getProfilePicture();
    }
}