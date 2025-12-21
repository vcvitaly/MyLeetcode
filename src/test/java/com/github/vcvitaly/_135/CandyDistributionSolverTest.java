package com.github.vcvitaly._135;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CandyDistributionSolverTest {

    private final CandyDistributionSolver solver = new CandyDistributionSolver();

    @Test
    void test1() {
        assertThat(solver.candy(new int[] {1,0,2}))
                .isEqualTo(5);
    }

    @Test
    void test2() {
        assertThat(solver.candy(new int[] {1,2,2}))
                .isEqualTo(4);
    }

    @Test
    void test3_1() {
        assertThat(solver.candy(new int[] {1,2,3}))
                .isEqualTo(6);
    }

    @Test
    void test3_2() {
        assertThat(solver.candy(new int[] {3,2,1}))
                .isEqualTo(6);
    }

    @Test
    void test4() {
        assertThat(solver.candy(new int[] {0,0,0}))
                .isEqualTo(3);
    }

    @Test
    void test5() {
        assertThat(solver.candy(new int[] {1,2,0}))
                .isEqualTo(4);
    }

    @Test
    void test6() {
        assertThat(solver.candy(new int[] {2,1,0}))
                .isEqualTo(6);
    }

    @Test
    void test7() {
        assertThat(solver.candy(new int[] {6,5,4,3,2,1,0}))
                .isEqualTo(28);
    }

    @Test
    void test8() {
        assertThat(solver.candy(new int[] {2,1,0,2,1,0,2,1,0}))
                .isEqualTo(18);
    }

    @Test
    void test9() {
        assertThat(solver.candy(new int[] {1,0,1}))
                .isEqualTo(5);
    }

    @Test
    void test10() {
        assertThat(solver.candy(new int[] {1,0,0,1}))
                .isEqualTo(6);
    }

    @Test
    void test11() {
        assertThat(solver.candy(new int[] {1,0,1,2}))
                .isEqualTo(8);
    }

    @Test
    void test12() {
        assertThat(solver.candy(new int[] {1,2,0,1,3,2}))
                .isEqualTo(10);
    }

    @Test
    void test13() {
        assertThat(solver.candy(new int[] {7,5,1,2,3,4,0,1}))
                .isEqualTo(16);
    }

    @Test
    void test14() {
        assertThat(solver.candy(new int[] {1,2,2,2,2}))
                .isEqualTo(6);
    }

    @Test
    void test15() {
        assertThat(solver.candy(new int[] {3,2,2,2,2}))
                .isEqualTo(6);
    }

    @Test
    void test16() {
        assertThat(solver.candy(new int[] {3,2,1,1,1}))
                .isEqualTo(8);
    }

    @Test
    void test17() {
        assertThat(solver.candy(new int[] {7,6,6,6,6,2}))
                .isEqualTo(8);
    }
}