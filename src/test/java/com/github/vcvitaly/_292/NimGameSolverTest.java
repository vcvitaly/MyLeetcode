package com.github.vcvitaly._292;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NimGameSolverTest {

    private final NimGameSolver solver = new NimGameSolver();

    @Test
    void test1() {
        assertThat(solver.canWinNim(1)).isTrue();
    }

    @Test
    void test2() {
        assertThat(solver.canWinNim(2)).isTrue();
    }

    @Test
    void test3() {
        assertThat(solver.canWinNim(4)).isFalse();
    }

    @Test
    void test4() {
        assertThat(solver.canWinNim(7)).isTrue();
    }
}