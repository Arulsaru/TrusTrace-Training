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
        update = new Update().set("followingCount", getUserById(userId).getFollowingCount() + 1);
        mongoTemplate.findAndModify(query, update, User.class);

        query = new Query().addCriteria(Criteria.where("userId").is(userIdToFollow));
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
        Post post = new Post(userId, imageUrl); // creating new post
        mongoTemplate.save(post);

        Update update = new Update();
        List<String> postIds = getUserById(userId).getPostIds();
        postIds.add(post.getPostId());
        update.set("postIds", postIds);
        update.set("totalNumberOfPosts", postIds.size());
        mongoTemplate.findAndModify(Query.query(Criteria.where("userId").is(userId)), update, User.class);
    }
    public Post getPostById(String postId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("postId").is(postId)), Post.class);
    }
    public void deleteAllPostOfAUser(String userId) {
        Update update = new Update();
        List<String> postIds = getUserById(userId).getPostIds();
        postIds.clear();   // postIds list ah mothama delete pandre
        update.set("postIds", postIds);
        update.set("totalNumberOfPosts", 0);
        query = new Query().addCriteria(Criteria.where("userId").is(userId));
        mongoTemplate.findAndModify(query, update, User.class);
        mongoTemplate.remove(query, Post.class);
    }
    public void deletePost(String userId, String postId) {
        update = new Update();
        List <String> postIds = getUserById(userId).getPostIds();
        postIds.remove(postId);
        update.set("postIds", postIds);
        update.set("totalNumberOfPosts", getUserById(userId).getTotalNumberOfPosts() - 1);
        mongoTemplate.findAndModify(Query.query(Criteria.where("userId").is(userId)), update, User.class);
        mongoTemplate.remove(Query.query(Criteria.where("postId").is(postId)), Post.class);
    }
    public void likePost(String postId) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("postId").is(postId)), Update.update("likeCount", getPostById(postId).getLikeCount() + 1), Post.class);
    }
}