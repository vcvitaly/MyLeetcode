package com.github.vcvitaly._198;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobbingOptimizerTest {

    private final HouseRobbingOptimizer optimizer = new HouseRobbingOptimizer();

    @Test
    void test1() {
        assertThat(optimizer.rob(new int[] {1,2,3,1})).isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(optimizer.rob(new int[] {2,7,9,3,1})).isEqualTo(12);
    }

    @Test
    void test3() {
        assertThat(optimizer.rob(new int[] {1})).isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(optimizer.rob(new int[] {2,1})).isEqualTo(2);
    }

    @Test
    void test5() {
        assertThat(optimizer.rob(new int[] {10,2,5,10})).isEqualTo(20);
    }

    @Test
    void test6() {
        assertThat(optimizer.rob(new int[] {10,10,2,10,20})).isEqualTo(32);
    }

    @Test
    void test7() {
        assertThat(optimizer.rob(new int[] {6,3,10,8,2,10,3,5,10,5,3})).isEqualTo(39);
    }

    @Test
    void test8() {
        assertThat(optimizer.rob(new int[] {
                114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,
                199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240
        })).isGreaterThan(1);
    }
}