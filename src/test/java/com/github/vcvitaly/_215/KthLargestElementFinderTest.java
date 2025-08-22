package com.github.vcvitaly._215;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementFinderTest {

    private final KthLargestElementFinder finder = new KthLargestElementFinder();

    @Test
    void test1() {
        assertThat(finder.findKthLargest(new int[] {3,2,1,5,6,4}, 2)).isEqualTo(5);
    }

    @Test
    void test2() {
        assertThat(finder.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)).isEqualTo(4);
    }

    @Test
    void test3() {
        assertThat(finder.findKthLargest(new int[] {3,2,3,1,2,5,5,4,6}, 4)).isEqualTo(4);
    }
}