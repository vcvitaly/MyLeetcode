package com.github.vcvitaly._146;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                new String[]  {"LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get","get"},
                new int[][]   {{3},{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},               {1},  {2},  {3},  {4},  {5},  {2}},
                new Integer[] {null,null,null,null,null,4,3,2,-1,null,                          -1,    2,    3,   -1,    5,    2}
        );
    }

    @Test
    void test5() {
        runTestHarness(
                new String[]  {"LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"},
                new int[][]   {{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}},
                new Integer[] {null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null}
        );
    }

    private void runTestHarness(String[] action, int[][] input, Integer[] expected) {
        if (action.length != input.length || input.length != expected.length) {
            throw new IllegalStateException("Array sizes are unaligned");
        }
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < action.length; i++) {
            System.out.printf("Action=%s,input=%s,expected=%s -> ", action[i], Arrays.toString(input[i]), expected[i]);
            if (action[i] == "LRUCache") {
                lruCache = new LRUCache(input[i][0]);
                printCacheState(lruCache, null);
                result.add(null);
            } else if (action[i] == "put") {
                lruCache.put(input[i][0], input[i][1]);
                printCacheState(lruCache, null);
                result.add(null);
            } else if (action[i] == "get") {
                int actual = lruCache.get(input[i][0]);
                printCacheState(lruCache, actual);
                result.add(actual);
            } else {
                throw new IllegalStateException("Illegal action: " + action[i]);
            }
            if (lruCache.head != null) {
                assertThat(lruCache.head.prev).isNull();
                assertThat(lruCache.tail.next).isNull();
            }
            assertThat(getKeys(lruCache.head)).containsExactlyInAnyOrderElementsOf(lruCache.m.keySet());
        }
        assertThat(result).containsExactly(expected);
    }

    private void printCacheState(LRUCache lruCache, Integer actual) {
        String state = "LRUCache{head=%s, tail=%s} after returning %d".formatted(toString(lruCache.head), toString(lruCache.tail), actual);
        System.out.println(state);
    }

    static List<Integer> getVals(LRUCache.DoublyLinkedListNode node) {
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

    static List<Integer> getKeys(LRUCache.DoublyLinkedListNode node) {
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.key);
            node = node.next;
        }
        return result;
    }

    static String toString(LRUCache.DoublyLinkedListNode node) {
        if (node == null) {
            return "null";
        }
        return "DoublyLinkedListNode{key=%d, linkedList=%s}".formatted(node.key, getKeys(node));
    }
}