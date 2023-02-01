package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.auth.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class LoginRepository implements QueryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;
    public String login(String email) {
        return Objects.requireNonNull(mongoTemplate.findOne(getQueryForEmail(email), SignUp.class)).getPassword();
    }
}
