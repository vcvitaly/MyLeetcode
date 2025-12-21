package com.github.vcvitaly._39;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumFinderTest {

    private final CombinationSumFinder finder = new CombinationSumFinder();

    @Test
    void test1() {
        assertThat(finder.combinationSum(new int[]{2,3,6,7}, 7))
                .containsExactlyInAnyOrder(List.of(2,2,3), List.of(7));
    }

    @Test
    void test2() {
        assertThat(finder.combinationSum(new int[]{2,3,5}, 8))
                .containsExactlyInAnyOrder(List.of(2,2,2,2), List.of(2,3,3), List.of(3,5));
    }

    @Test
    void test3() {
        assertThat(finder.combinationSum(new int[]{2}, 1))
                .isEmpty();
    }
}