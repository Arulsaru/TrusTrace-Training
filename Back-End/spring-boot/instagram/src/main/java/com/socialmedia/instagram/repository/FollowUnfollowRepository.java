package com.socialmedia.instagram.repository;

import com.socialmedia.instagram.pojo.Followers;
import com.socialmedia.instagram.pojo.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FollowUnfollowRepository implements QueryImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    Update update;
    public List<String> getFollowingList(String userId) {
        return mongoTemplate.findOne(getQueryForUserId(userId), Following.class).getFollowingList();
    }
    public List<String> getFollowersList(String userId) {
        return mongoTemplate.findOne(getQueryForUserId(userId), Followers.class).getFollowersList();
    }
    public void followUser(String userId, String userIdToFollow) {
        update = new Update();
        update.inc("followingCount");
        update.push("followingList", userIdToFollow);
        mongoTemplate.findAndModify(getQueryForUserId(userId), update, Following.class);

        update = new Update();
        update.inc("followersCount");
        update.push("followersList", userId);
        mongoTemplate.findAndModify(getQueryForUserId(userId), update, Followers.class);
    }
    public void unfollowUser(String userId, String userIdToUnfollow) {
        update = new Update();
        update.inc("followingCount", -1);
        update.pull("followingList", userIdToUnfollow);
        mongoTemplate.findAndModify(getQueryForUserId(userId), update, Following.class);

        update = new Update();
        update.inc("followersCount", -1);
        update.pull("followersList", userId);
        mongoTemplate.findAndModify(getQueryForUserId(userId), update, Followers.class);
    }

}
