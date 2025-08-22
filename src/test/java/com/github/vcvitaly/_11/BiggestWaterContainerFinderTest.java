package com.github.vcvitaly._11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BiggestWaterContainerFinderTest {

    private final BiggestWaterContainerFinder finder = new BiggestWaterContainerFinder();

    @Test
    void test1() {
        assertThat(finder.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
    }

    @Test
    void test2() {
        assertThat(finder.maxArea(new int[]{1,1})).isEqualTo(1);
    }
}