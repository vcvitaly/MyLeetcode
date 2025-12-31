package com.github.vcvitaly._80;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SortedArrayDupRemover2Test {

    private final SortedArrayDupRemover2 remover = new SortedArrayDupRemover2();

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = remover.removeDuplicates(nums);
        assertThat(k).isEqualTo(5);
        assertThat(Arrays.stream(nums).limit(k).toArray()).containsExactly(1, 2, 3);
    }

    @Test
    void test2() {
        int[] nums = {1,1,1,2,2,3};
        int k = remover.removeDuplicates(nums);
        assertThat(k).isEqualTo(5);
        assertThat(Arrays.stream(nums).limit(k).toArray()).containsExactly(1, 1, 2, 2, 3);
    }

    @Test
    void test3() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int k = remover.removeDuplicates(nums);
        assertThat(k).isEqualTo(7);
        assertThat(Arrays.stream(nums).limit(k).toArray()).containsExactly(0, 0, 1, 1, 2, 3, 3);
    }
}