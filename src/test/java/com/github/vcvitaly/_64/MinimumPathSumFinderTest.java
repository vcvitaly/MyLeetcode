package com.github.vcvitaly._64;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumPathSumFinderTest {

    private MinimumPathSumFinder finder = new MinimumPathSumFinder();

    @Test
    void test1() {
        assertThat(finder.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}))
                .isEqualTo(7);
    }

    @Test
    void test2() {
        assertThat(finder.minPathSum(new int[][]{{1,2,3},{4,5,6}}))
                .isEqualTo(12);
    }
}