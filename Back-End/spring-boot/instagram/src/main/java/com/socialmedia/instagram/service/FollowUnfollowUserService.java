package com.socialmedia.instagram.service;

import com.socialmedia.instagram.repository.FollowUnfollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowUnfollowUserService {
    @Autowired
    FollowUnfollowRepository followUnfollowRepository;
    public void followUser(String userId, String userIdToFollow) throws Exception {
//        followUnfollowValidator.preValidate(userId, userIdToFollow, true);
        followUnfollowRepository.followUser(userId, userIdToFollow);
    }
    public void unFollowUser(String userId, String userIdToUnfollow) throws Exception {
//        followUnfollowValidator.preValidate(userId, userIdToUnfollow, false);
        followUnfollowRepository.unfollowUser(userId, userIdToUnfollow);
    }
}
