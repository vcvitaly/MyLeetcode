package com.github.vcvitaly._303;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumArrayTest {

    private NumArray numArray;

    @Test
    void test1() {
         numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

        assertThat(numArray.sumRange(0,2)).isEqualTo(1);
    }

    @Test
    void test2() {
        numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

        assertThat(numArray.sumRange(2,5)).isEqualTo(-1);
    }

    @Test
    void test3() {
        numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

        assertThat(numArray.sumRange(0,5)).isEqualTo(-3);
    }

    @Test
    void test4() {
        numArray = new NumArray(new int[] {1,4,-6});

        assertThat(numArray.sumRange(1,2)).isEqualTo(-2);
    }

    @Test
    void test5() {
        numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, 1});

        assertThat(numArray.sumRange(2,5)).isEqualTo(1);
    }

    @Test
    void test6() {
        numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, 3});

        assertThat(numArray.sumRange(0,5)).isEqualTo(1);
    }
}