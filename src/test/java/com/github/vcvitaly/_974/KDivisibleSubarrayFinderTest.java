package com.github.vcvitaly._974;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KDivisibleSubarrayFinderTest {

    private final KDivisibleSubarrayFinder finder = new KDivisibleSubarrayFinder();

    @Test
    void test1() {
        assertThat(finder.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5))
                .isEqualTo(7);
    }

    @Test
    void test2() {
        assertThat(finder.subarraysDivByK(new int[]{5}, 9))
                .isEqualTo(0);
    }
}