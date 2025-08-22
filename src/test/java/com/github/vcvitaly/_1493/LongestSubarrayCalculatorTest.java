package com.github.vcvitaly._1493;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubarrayCalculatorTest {

    private final LongestSubarrayCalculator calculator = new LongestSubarrayCalculator();

    @Test
    void test1() {
        assertThat(calculator.longestSubarray(new int[] {1,1,0,1}))
                .isEqualTo(3);
    }

    @Test
    void test2() {
        assertThat(calculator.longestSubarray(new int[] {0,1,1,1,0,1,1,0,1}))
                .isEqualTo(5);
    }

    @Test
    void test3() {
        assertThat(calculator.longestSubarray(new int[] {1,1,1}))
                .isEqualTo(2);
    }

    @Test
    void test4() {
        assertThat(calculator.longestSubarray(new int[] {0,1,1,1,0,1,1,0,1,1,1,1}))
                .isEqualTo(6);
    }
}