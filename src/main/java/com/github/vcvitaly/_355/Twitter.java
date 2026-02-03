package com.github.vcvitaly._355;

import java.util.*;

// 1. Fast write, slow reads with merge k sorted lists naive approach
// 2. Maintain a priority Q of sorted lists for each user, slower writes
// 3. Fanout approach with maintain top 10 tweets per user
public class Twitter {

    private static final int TOP_K_COUNT = 10;
    private final Map<Integer, Set<Integer>> followeesByUser = new HashMap<>();
    private final Map<Integer, List<Integer>> tweetsByUser = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweetsByUser.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        final Set<Integer> followees = followeesByUser.get(userId);
        if (followees == null || followees.isEmpty()) {
            return List.of();
        }
        final List<Integer> resultTweets = new ArrayList<>(TOP_K_COUNT);
        final Map<Integer, Integer> positionByUser = new HashMap<>();
        for (int i = 0; i < TOP_K_COUNT; i++) {
            int maxTweet = -1;
            int maxTweetAuthorId = 0;
            for (Integer followee : followees) {
                Integer nextIndexByFollowee = positionByUser.computeIfAbsent(followee, k -> tweetsByUser.get(k).size() - 1);
                Integer nextMaxTweetByThisFollowee = tweetsByUser.get(followee).get(nextIndexByFollowee);
                if (nextMaxTweetByThisFollowee > maxTweet) {
                    maxTweet = nextMaxTweetByThisFollowee;
                    maxTweetAuthorId = followee;
                }
            }
            resultTweets.add(maxTweet);
            positionByUser.compute(maxTweetAuthorId, (k, nextIndexByFollowee) -> nextIndexByFollowee - 1);
        }
        return resultTweets;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            throw new IllegalArgumentException("User cannot follow himself");
        }
        followeesByUser.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            throw new IllegalArgumentException("User cannot unfollow himself");
        }
        final Set<Integer> followees = this.followeesByUser.get(followerId);
        followees.remove(followeeId);
    }
}
