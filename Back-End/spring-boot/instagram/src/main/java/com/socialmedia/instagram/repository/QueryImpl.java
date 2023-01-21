package com.socialmedia.instagram.repository;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public interface QueryImpl {
    public default Query getQueryForUserId(String userId) {
        return Query.query(Criteria.where("userId").is(userId));
    }
    public default Query getQueryForUserName(String userName) {
        return Query.query(Criteria.where("userName").is(userName));
    }
    public default Query getQueryForPostId(String postId) {
        return Query.query(Criteria.where("postId").is(postId));
    }
}
