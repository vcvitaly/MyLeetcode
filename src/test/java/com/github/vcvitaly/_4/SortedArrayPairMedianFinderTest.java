package com.github.vcvitaly._4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortedArrayPairMedianFinderTest {

    private final SortedArrayPairMedianFinder finder = new SortedArrayPairMedianFinder();

    @Test
    void test1() {
        assertThat(finder.findMedianSortedArrays(
                new int[] {1,3}, new int[] {2}
        )).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(finder.findMedianSortedArrays(
                new int[] {1,2}, new int[] {3,4}
        )).isEqualTo(2.5);
    }

    @Test
    void test3() {
        assertThat(finder.findMedianSortedArrays(
                new int[] {1,1,1}, new int[] {2,2,2}
        )).isEqualTo(3);
    }

    @Test
    void test4() {
        assertThat(finder.findMedianSortedArrays(
                new int[] {1,2,3}, new int[] {4}
        )).isEqualTo(2.5);
    }
}