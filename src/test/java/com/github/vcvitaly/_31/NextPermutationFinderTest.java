package com.github.vcvitaly._31;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextPermutationFinderTest {

    private final NextPermutationFinder finder = new NextPermutationFinder();

    @Test
    void test1() {
        final int[] nums = new int[] {1,2,3};
        finder.nextPermutation(nums);
        assertThat(nums).containsExactly(1,3,2);
    }

    @Test
    void test2() {
        final int[] nums = new int[] {3,2,1};
        finder.nextPermutation(nums);
        assertThat(nums).containsExactly(1,2,3);
    }

    @Test
    void test3() {
        final int[] nums = new int[] {1,1,5};
        finder.nextPermutation(nums);
        assertThat(nums).containsExactly(1,5,1);
    }
}