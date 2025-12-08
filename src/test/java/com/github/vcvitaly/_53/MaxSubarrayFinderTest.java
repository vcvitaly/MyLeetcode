package com.github.vcvitaly._53;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubarrayFinderTest {

    private MaxSubarrayFinder finder = new MaxSubarrayFinder();

    @Test
    void test1() {
        assertThat(finder.maxSubArray(new int[] {1,2,3,4})).isEqualTo(10);
    }

    @Test
    void test2() {
        assertThat(finder.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})).isEqualTo(6);
    }

    @Test
    void test3() {
        assertThat(finder.maxSubArray(new int[] {1})).isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(finder.maxSubArray(new int[] {5,4,-1,7,8})).isEqualTo(23);
    }

    @Test
    void test5() {
        assertThat(finder.maxSubArray(new int[] {-1,4,-100,1,-1})).isEqualTo(4);
    }
}