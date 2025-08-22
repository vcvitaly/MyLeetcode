package com.github.vcvitaly._1143;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LcsFinderTest {

    private final LcsFinder finder = new LcsFinder();

    @Test
    void test1() {
        assertThat(finder.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
    }

    @Test
    void test2() {
        assertThat(finder.longestCommonSubsequence("abc", "abc")).isEqualTo(3);
    }

    @Test
    void test3() {
        assertThat(finder.longestCommonSubsequence("abc", "def")).isEqualTo(0);
    }
}