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
import java.util.Random;

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
    public void createUser(User user) { mongoTemplate.save(user); }
    public void deleteUser(String userId) {
        mongoTemplate.remove(Query.query(Criteria.where("userId").is(userId)), User.class);
    }
    public void followUser(String userId, String userIdToFollow) {
        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        System.out.println( userId + " " + getUserById(userId).getFollowingCount());
        update = new Update().set("followingCount", getUserById(userId).getFollowingCount() + 1);
        mongoTemplate.findAndModify(query, update, User.class);

        query = new Query().addCriteria(Criteria.where("userId").is(userIdToFollow));
        System.out.println(userId + " " + getUserById(userIdToFollow).getFollowingCount());
        update = new Update().set("followersCount", getUserById(userIdToFollow).getFollowersCount() + 1);
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void unfollowUser(String userId, String userIdToUnfollow) { // logic maathanu

        // follow pannama unfollow kulla varatha maathiri logic eludhanu

        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        update = new Update().set("followingCount", getUserById(userId).getFollowingCount() - 1);
        mongoTemplate.findAndModify(query, update, User.class);

        query = new Query().addCriteria(Criteria.where("userId").is(userIdToUnfollow));
        update = new Update().set("followersCount", getUserById(userIdToUnfollow).getFollowersCount() - 1);
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void createPost(String userId, String imageUrl) {

        List<Integer> postIds = getUserById(userId).getPostIds();

        Post post = new Post(userId,postIds.size() + 1, imageUrl); // creating new post
        mongoTemplate.save(post);

        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
        Update update = new Update();
        postIds.add(postIds.size() + 1);
        update.set("postIds", postIds);
        update.set("totalNumberOfPosts", postIds.size());
        mongoTemplate.findAndModify(query, update, User.class);
    }
    public void deleteAllPostOfAUser(String userId) {
        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        Update update = new Update();
        List<Integer> postIds = getUserById(userId).getPostIds();
        postIds.clear();   // postIds list ah mothama delete pandre
        update.set("postIds", postIds);
        update.set("totalNumberOfPosts", 0);
        mongoTemplate.findAndModify(query, update, User.class);
        mongoTemplate.remove(query, Post.class);
    }
    public void deletePost(String userId, String postId) {
//        query = new Query().addCriteria(new Criteria().andOperator(Criteria.where("userId").is(userId), Criteria.where("postId").is(postId)));

        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        System.out.println(query);
        System.out.println(mongoTemplate.remove(query, Post.class));
    }
}