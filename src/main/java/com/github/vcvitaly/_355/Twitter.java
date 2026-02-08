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
        final List<Integer> followeesSnapshot = new ArrayList<>(followeesByUser.getOrDefault(userId, Set.of()));
        followeesSnapshot.add(userId);
        final List<Integer> resultTweets = new ArrayList<>();
        final Map<Integer, Integer> positionByUser = new HashMap<>();
        for (int i = 0; i < TOP_K_COUNT; i++) {
            int maxTweet = -1;
            int maxTweetAuthor = -1;
            for (int j = followeesSnapshot.size() - 1; j >= 0; j--) {
                Integer followee = followeesSnapshot.get(j);
                int nextIndexByFollowee = positionByUser.computeIfAbsent(followee, k -> {
                    final List<Integer> tweets = tweetsByUser.get(k);
                    if (tweets == null) {
                        return -1;
                    }
                    return tweets.size() - 1;
                });
                if (nextIndexByFollowee < 0) {
                    followeesSnapshot.remove(j);
                    continue;
                }
                Integer nextMaxTweetByThisFollowee = tweetsByUser.get(followee).get(nextIndexByFollowee);
                if (nextMaxTweetByThisFollowee > maxTweet) {
                    maxTweet = nextMaxTweetByThisFollowee;
                    maxTweetAuthor = followee;
                }
            }
            if (maxTweet > 0) {
                resultTweets.add(maxTweet);
                positionByUser.compute(maxTweetAuthor, (k, nextIndexByFollowee) -> {
                    if (nextIndexByFollowee == null) {
                        throw new IllegalStateException("Null index for " + k);
                    }
                    return nextIndexByFollowee - 1;
                });
            }
            if (followeesSnapshot.isEmpty()) {
                return resultTweets;
            }
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
