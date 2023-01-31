package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.FollowUnfollowRepository;
import com.socialmedia.instagram.repository.UserRepository;
import com.socialmedia.instagram.service.validators.FollowUnfollowValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowUnfollowUserService {
    @Autowired
    FollowUnfollowRepository followUnfollowRepository;
    @Autowired
    FollowUnfollowValidator followUnfollowValidator;
    @Autowired
    UserRepository userRepository;
    public void followUser(String userId, String userIdToFollow) throws Exception {
        followUnfollowValidator.preValidate(userId, userIdToFollow, true);
        userRepository.updateFollowerCount(userId, 1);
        userRepository.updateFollowingCount(userIdToFollow, 1);
        followUnfollowRepository.followUser(userId, userIdToFollow);
    }
    public void unFollowUser(String userId, String userIdToUnfollow) throws Exception {
        followUnfollowValidator.preValidate(userId, userIdToUnfollow, false);
        userRepository.updateFollowerCount(userId, -1);
        userRepository.updateFollowingCount(userIdToUnfollow, -1);
        followUnfollowRepository.unfollowUser(userId, userIdToUnfollow);
    }
}
