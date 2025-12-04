package com.github.vcvitaly._5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromeFinderTest {

    private final LongestPalindromeFinder finder = new LongestPalindromeFinder();

    @Test
    void test1() {
        assertThat(finder.longestPalindrome("babad")).isEqualTo("bab");
    }

    @Test
    void test2() {
        assertThat(finder.longestPalindrome("cbbd")).isEqualTo("bb");
    }

    @Test
    void test3() {
        assertThat(finder.longestPalindrome("aabbb")).isEqualTo("bbb");
    }

    @Test
    void test4() {
        assertThat(finder.longestPalindrome("aaaaaaaaaa")).isEqualTo("aaaaaaaaaa");
    }

    @Test
    void test5() {
        assertThat(finder.longestPalindrome("abaaaaaaaa")).isEqualTo("aaaaaaaa");
    }
}