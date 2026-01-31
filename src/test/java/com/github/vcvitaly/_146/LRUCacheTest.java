package com.github.vcvitaly._146;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    private LRUCache lruCache;

    @Test
    void test1() {
        runTestHarness(
                new String[] {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"},
                new int[][] {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}},
                new Integer[] {null, null, null, 1, null, -1, null, -1, 3, 4}
        );
    }

    @Test
    void test2() {
        lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        assertThat(lruCache.get(2)).isEqualTo(1);
        lruCache.put(3, 2);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        assertThat(lruCache.get(3)).isEqualTo(2);
    }

    @Test
    void test3() {
        lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        assertThat(lruCache.get(2)).isEqualTo(2);
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        assertThat(lruCache.get(2)).isEqualTo(-1);
    }

    @Test
    void test4() {
        runTestHarness(
                new String[] {"LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"},
                new int[][] {{3},{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},{1},{2},{3},{4},{5}},
                new Integer[] {null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5}
        );
    }

    private void runTestHarness(String[] action, int[][] input, Integer[] expected) {
        if (action.length != input.length || input.length != expected.length) {
            throw new IllegalStateException("Array sizes are unaligned");
        }
        SoftAssertions softly = new SoftAssertions();
        for (int i = 0; i < action.length; i++) {
            if (action[i] == "LRUCache") {
                lruCache = new LRUCache(input[i][0]);
            } else if (action[i] == "put") {
                lruCache.put(input[i][0], input[i][1]);
            } else if (action[i] == "get") {
                softly.assertThat(lruCache.get(input[i][0])).isEqualTo(expected[i]);
            } else {
                throw new IllegalStateException("Illegal action: " + action[i]);
            }
        }
        softly.assertAll();
    }
}