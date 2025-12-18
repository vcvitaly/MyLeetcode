package com.github.vcvitaly._209;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinSizeSubarrayFinderTest {

    private final MinSizeSubarrayFinder finder = new MinSizeSubarrayFinder();

    @Test
    void test1() {
        assertThat(finder.minSubArrayLen(7, new int[]{2,3,1,2,4,3})).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(finder.minSubArrayLen(4, new int[]{1,1,4,4})).isEqualTo(1);
    }

    @Test
    void test3() {
        assertThat(finder.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})).isZero();
    }

    @Test
    void test4() {
        assertThat(finder.minSubArrayLen(11, new int[]{1,2,3,4,5})).isEqualTo(3);
    }

    @Test
    void test5() {
        assertThat(finder.minSubArrayLen(11, new int[]{3,4,5})).isEqualTo(3);
    }
}