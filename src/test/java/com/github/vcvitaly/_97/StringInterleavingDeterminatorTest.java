package com.github.vcvitaly._97;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringInterleavingDeterminatorTest {

    private final StringInterleavingDeterminator determinator = new StringInterleavingDeterminator();

    @Test
    void test1() {
        assertThat(determinator.isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
    }
    // dbbac

    @Test
    void test2() {
        assertThat(determinator.isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
    }
    // dbbac

    @Test
    void test3() {
        assertThat(determinator.isInterleave("", "", "")).isTrue();
    }

    @Test
    void test4() {
        assertThat(determinator.isInterleave("aaa", "bbb", "ababab")).isTrue();
    }

    @Test
    void test5() {
        assertThat(determinator.isInterleave("aaa", "bbb", "bababa")).isTrue();
    }
}