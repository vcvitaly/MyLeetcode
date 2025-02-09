package com.github.vcvitaly._44;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WildcardMatcherTest {

    private final WildcardMatcher matcher = new WildcardMatcher();

    @Test
    void test1() {
        assertThat(matcher.isMatch("aa", "a")).isFalse();
    }

    @Test
    void test2() {
        assertThat(matcher.isMatch("aa", "*")).isTrue();
    }

    @Test
    void test3() {
        assertThat(matcher.isMatch("cb", "?a")).isFalse();
    }

    @Test
    void test4() {
        assertThat(matcher.isMatch("aaaa", "*a?")).isFalse();
    }
}