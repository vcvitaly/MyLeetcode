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
}