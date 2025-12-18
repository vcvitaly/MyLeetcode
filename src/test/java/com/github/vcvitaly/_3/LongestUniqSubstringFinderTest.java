package com.github.vcvitaly._3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestUniqSubstringFinderTest {

    private final LongestUniqSubstringFinder finder = new LongestUniqSubstringFinder();

    @Test
    void test1() {
        assertThat(finder.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    void test2() {
        assertThat(finder.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    void test3() {
        assertThat(finder.lengthOfLongestSubstring("abcdefgha")).isEqualTo(8);
    }

    @Test
    void test4() {
        assertThat(finder.lengthOfLongestSubstring(" ")).isEqualTo(1);
    }

    @Test
    void test5() {
        assertThat(finder.lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }

    @Test
    void test6() {
        assertThat(finder.lengthOfLongestSubstring("dvdfabca123456789")).isEqualTo(12);
    }

    @Test
    void test7() {
        assertThat(finder.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }
}