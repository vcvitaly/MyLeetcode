package com.github.vcvitaly._139;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class WordBreakDeterminatorTest {

    private final WordBreakDeterminator determinator = new TrieWordBreakDeterminator();

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
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test6() {
        final String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        assertThat(determinator.wordBreak(
                s, List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
        )).isFalse();
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test7() {
        final String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertThat(determinator.wordBreak(
                s, List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
        )).isTrue();
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test8() {
        final String s = "abababababababababababababababababababababababababababababababababababababababababababababababababab";
        assertThat(determinator.wordBreak(s, List.of("a", "ab", "aa", "ac", "b", "aaaa"))).isTrue();
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test9() {
        final String s = "abcdefgjihklmnoprstuwxyzabcdefgjihklmnoprstuwxyzabcdefgjihklmnoprstuwxyzabcdefgjihklmnoprstuwxyz";
        assertThat(determinator.wordBreak(s, List.of("a", "ab", "aa", "ac", "b"))).isFalse();
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test10() {
        final String s = "aabcdefgjihklmnoprstuwxyzy";
        assertThat(determinator.wordBreak(s, List.of("a", "abcdefgjihklmnoprstuwxyz", "b"))).isFalse();
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test11() {
        final String s = "babcdefgjihklmnoprstuwxyzaaa";
        assertThat(determinator.wordBreak(s, List.of("abcdefgjihklmnoprstuwxyz", "bbb", "abcdefgjihklmnoprstuwxy", "zaaa", "b")))
                .isTrue();
    }

    @Test
    @Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void test12() {
        final String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "baab" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertThat(determinator.wordBreak(
                s, List.of("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba")
        )).isFalse();
    }
}