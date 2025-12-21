package com.github.vcvitaly._1143;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LcsFinderTest {

    private final LcsFinder finder = new LcsFinder();

    @Test
    void test1() {
        assertThat(finder.longestCommonSubsequence("abcde", "ace")).isEqualTo(3); // ace
    }

    @Test
    void test2() {
        assertThat(finder.longestCommonSubsequence("abc", "abc")).isEqualTo(3);
    } // ace

    @Test
    void test3() {
        assertThat(finder.longestCommonSubsequence("abc", "def")).isZero();
    } // no cs

    @Test
    void test4() {
        assertThat(finder.longestCommonSubsequence("ace", "abcde")).isEqualTo(3); // ace
    }

    @Test
    void test5() {
        assertThat(finder.longestCommonSubsequence("abcde", "aec")).isEqualTo(2); // ae or ac
    }

    @Test
    void test6() {
        assertThat(finder.longestCommonSubsequence("ababadadaddx", "ababadadaddy")).isEqualTo(11); // ababadadadd
    }

    @Test
    void test7() {
        assertThat(finder.longestCommonSubsequence("ababadadaddx", "aaaadaddy")).isEqualTo(8); // aaaadadd
    }

    @Test
    void test8() {
        assertThat(finder.longestCommonSubsequence("aaabbb", "bbbaaa")).isEqualTo(3); // aaa or bbb
    }

    @Test
    void test9() {
        assertThat(finder.longestCommonSubsequence("aaaabbb", "bbbaaaa")).isEqualTo(4); // aaaa
    }

    @Test
    void test10() {
        assertThat(finder.longestCommonSubsequence("abccde", "edccba")).isEqualTo(2); // cc
    }

    @Test
    void test11() {
        assertThat(finder.longestCommonSubsequence("aaabbbb", "aaaabbb")).isEqualTo(6); // aaabbb
    }

    @Test
    void test12() {
        assertThat(finder.longestCommonSubsequence("abbacca", "aaabbcc")).isEqualTo(4); // bbcc
    }
}