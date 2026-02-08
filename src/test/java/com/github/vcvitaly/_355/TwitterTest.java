package com.github.vcvitaly._355;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TwitterTest {

    private final Twitter twitter = new Twitter();

    @Test
    void test1() {
        runTestHarness(
                new String[] {"postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"},
                new int[][] {{1, 5}, {1}, {1, 2}, {2, 6}, {1}, {1, 2}, {1}},
                Arrays.asList(null, List.of(5), null, null, List.of(6, 5), null, List.of(5))
        );
    }

    @Test
    void test2() {
        runTestHarness(
                new String[] {"postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"},
                new int[][] {{1,1},{1},{2,1},{2},{2,1},{2}},
                Arrays.asList(null, List.of(1), null, List.of(1), null, List.of())
        );
    }

    private void runTestHarness(String[] actions, int[][] arguments, List<List<Integer>> expectedResults) {
        for (int i = 0; i < actions.length; i++) {
            try {
                if (actions[i].equals("postTweet")) {
                    twitter.postTweet(arguments[i][0], arguments[i][1]);
                } else if (actions[i].equals("getNewsFeed")) {
                    final List<Integer> newsFeed = twitter.getNewsFeed(arguments[i][0]);
                    final List<Integer> expected = expectedResults.get(i);
                    int finalI = i;
                    assertThat(newsFeed)
                            .withFailMessage(() -> "Expecting getNewsFeed to return %s at step %d but it returned %s"
                                    .formatted(expected, finalI, newsFeed))
                            .containsExactlyElementsOf(expected);
                } else if (actions[i].equals("follow")) {
                    twitter.follow(arguments[i][0], arguments[i][1]);
                } else if (actions[i].equals("unfollow")) {
                    twitter.unfollow(arguments[i][0], arguments[i][1]);
                } else {
                    throw new IllegalArgumentException("Unknown action: " + actions[i]);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error at step " + i, e);
            }
        }
    }
}