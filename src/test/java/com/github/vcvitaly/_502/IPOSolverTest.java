package com.github.vcvitaly._502;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IPOSolverTest {

    private final IPOSolver solver = new IPOSolver();

    @Test
    void test1() {
        assertThat(solver.findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}))
                .isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(solver.findMaximizedCapital(3, 0, new int[]{1,2,3}, new int[]{0,1,2}))
                .isEqualTo(6);
    }

    @Test
    void test3() {
        assertThat(solver.findMaximizedCapital(1, 0, new int[]{1}, new int[]{0}))
                .isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(solver.findMaximizedCapital(1, 0, new int[]{1}, new int[]{1}))
                .isZero();
    }
}