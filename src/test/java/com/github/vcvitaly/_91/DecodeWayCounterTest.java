package com.github.vcvitaly._91;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecodeWayCounterTest {

    private final DecodeWayCounter counter = new DecodeWayCounter();

    @Test
    void test1() {
        assertThat(counter.numDecodings("12")).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(counter.numDecodings("226")).isEqualTo(3);
    }

    @Test
    void test3() {
        assertThat(counter.numDecodings("06")).isZero();
    }

    @Test
    void test4() {
        assertThat(counter.numDecodings("1111")).isEqualTo(5);
    }
}