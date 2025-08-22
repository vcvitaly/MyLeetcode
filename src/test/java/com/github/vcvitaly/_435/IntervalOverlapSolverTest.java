package com.github.vcvitaly._435;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntervalOverlapSolverTest {

    private final IntervalOverlapSolver solver = new IntervalOverlapSolver();

    @Test
    void test1() {
        assertThat(solver.eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}))
                .isEqualTo(1);
    }

    @Test
    void test2() {
        assertThat(solver.eraseOverlapIntervals(new int[][] {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}))
                .isEqualTo(2);
    }

    @Test
    void test3() {
        assertThat(solver.eraseOverlapIntervals(new int[][] {{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}}))
                .isEqualTo(4);
    }

    @Test
    void test4() {
        assertThat(solver.eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}))
                .isEqualTo(2);
    }

    @Test
    void test5() {
        assertThat(solver.eraseOverlapIntervals(new int[][] {{1,2},{2,3}}))
                .isEqualTo(0);
    }
}