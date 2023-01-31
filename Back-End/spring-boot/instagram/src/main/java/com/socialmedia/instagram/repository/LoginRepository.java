package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.User;
import com.socialmedia.instagram.pojo.auth.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements QueryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;
    public String login(String userId, String password) {
        return mongoTemplate.findOne(getQueryForUserId(userId), SignUp.class).getPassword();
    }
}
