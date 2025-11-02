package com.github.vcvitaly._10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegExMatcherTest {

    private final RegExMatcher regExMatcher = new RegExMatcher();

    @Test
    void test1() {
        assertThat(regExMatcher.isMatch("aa", "a")).isFalse();
    }

    @Test
    void test2() {
        assertThat(regExMatcher.isMatch("aa", "a*")).isTrue();
    }

    @Test
    void test3() {
        assertThat(regExMatcher.isMatch("ab", ".*")).isTrue();
    }

    @Test
    void test4() {
        assertThat(regExMatcher.isMatch("aaab", "a*b")).isTrue();
    }

    @Test
    void test5() {
        assertThat(regExMatcher.isMatch("aaac", "a*b")).isFalse();
    }

    @Test
    void test6() {
        assertThat(regExMatcher.isMatch("b", "a")).isFalse();
    }

    @Test
    void test7() {
        assertThat(regExMatcher.isMatch("b", "ab")).isFalse();
    }

    @Test
    void test8() {
        assertThat(regExMatcher.isMatch("aaa", "aaaa")).isFalse();
    }

    @Test
    void test9() {
        assertThat(regExMatcher.isMatch("aaa", "a*a")).isTrue();
    }

    @Test
    void test9_1() {
        assertThat(regExMatcher.isMatch("aaaa", "a*aa")).isTrue();
    }

    @Test
    void test9_2() {
        assertThat(regExMatcher.isMatch("aaaaa", "aa*aa")).isTrue();
    }

    @Test
    void test10() {
        assertThat(regExMatcher.isMatch("aaaa", "a.*a")).isTrue();
    }

    @Test
    void test11() {
        assertThat(regExMatcher.isMatch("aaaa", "a.*b")).isFalse();
    }

    @Test
    void test12() {
        assertThat(regExMatcher.isMatch("aaaaa", "a.*ab")).isFalse();
    }
}