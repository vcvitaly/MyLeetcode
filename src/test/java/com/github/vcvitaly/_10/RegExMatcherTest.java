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
}