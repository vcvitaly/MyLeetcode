package com.github.vcvitaly._139;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordBreakDeterminatorTest {

    private final WordBreakDeterminator determinator = new TrielessWordBreakDeterminator();

    @Test
    void test1() {
        assertThat(determinator.wordBreak("leetcode", List.of("leet","code"))).isTrue();
    }

    @Test
    void test2() {
        assertThat(determinator.wordBreak("applepenapple", List.of("apple","pen"))).isTrue();
    }

    @Test
    void test3() {
        assertThat(determinator.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"))).isFalse();
    }

    @Test
    void test4() {
        assertThat(determinator.wordBreak("cat", List.of("cat"))).isTrue();
    }

    @Test
    void test5() {
        assertThat(determinator.wordBreak("cars", List.of("car", "ca", "rs"))).isTrue();
    }

    @Test
    void test6() {
        final String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        assertThat(determinator.wordBreak(
                s, List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
        )).isFalse();
    }

    @Test
    void test7() {
        final String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertThat(determinator.wordBreak(
                s, List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
        )).isTrue();
    }
}