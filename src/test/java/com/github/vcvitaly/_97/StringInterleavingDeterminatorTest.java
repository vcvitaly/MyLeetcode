package com.github.vcvitaly._97;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringInterleavingDeterminatorTest {

    private final StringInterleavingDeterminator determinator = new StringInterleavingDeterminator();

    @Test
    void test1() {
        assertThat(determinator.isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
    }

    @Test
    void test2() {
        assertThat(determinator.isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
    }

    @Test
    void test3() {
        assertThat(determinator.isInterleave("", "", "")).isTrue();
    }
}