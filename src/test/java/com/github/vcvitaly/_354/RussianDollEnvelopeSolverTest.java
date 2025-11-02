package com.github.vcvitaly._354;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RussianDollEnvelopeSolverTest {

    private final RussianDollEnvelopeSolver solver = new RussianDollEnvelopeSolver();

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

    @Test
    void test3() {
        assertThat(solver.maxEnvelopes(new int[][]{{10,4},{9,3},{6,8},{5,7},{4,6}}))
                .isEqualTo(3);
    }

    @Test
    void test4() {
        assertThat(solver.maxEnvelopes(new int[][]{{1,1}}))
                .isEqualTo(1);
    }

    @Test
    void test5() {
        assertThat(solver.maxEnvelopes(new int[][]{{8,3},{3,20},{15,5},{11,2},{19,6},{9,18},{1,19},{13,3},{14,20},{6,7}}))
                .isEqualTo(4);
    }
}