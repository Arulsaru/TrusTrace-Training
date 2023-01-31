package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.auth.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void signUp(SignUp signUp) {
        mongoTemplate.save(signUp);
    }
}