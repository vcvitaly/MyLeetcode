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
}