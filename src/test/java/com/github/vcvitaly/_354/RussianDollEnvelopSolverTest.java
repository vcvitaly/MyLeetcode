package com.github.vcvitaly._354;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RussianDollEnvelopSolverTest {

    private final RussianDollEnvelopSolver solver = new RussianDollEnvelopSolver();

    @Test
    void test1() {
        assertThat(solver.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}))
                .isEqualTo(3);
    }

    @Test
    void test2() {
        assertThat(solver.maxEnvelopes(new int[][]{{1,1},{1,1},{1,1}}))
                .isEqualTo(1);
    }
}