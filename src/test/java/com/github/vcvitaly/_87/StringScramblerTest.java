package com.github.vcvitaly._87;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringScramblerTest {

    private final StringScrambler scrambler = new StringScrambler();

    @Test
    void test1() {
        assertThat(scrambler.isScramble("great", "rgeat")).isTrue();
    }

    @Test
    void test2() {
        assertThat(scrambler.isScramble("abcde", "caebd")).isFalse();
    }

    @Test
    void test3() {
        assertThat(scrambler.isScramble("a", "a")).isTrue();
    }
}