package com.github.vcvitaly._118;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PascalTriangleSolverTest {

    private final PascalTriangleSolver solver = new PascalTriangleSolver();

    @Test
    void test1() {
        assertThat(solver.generate(1))
                .containsExactly(List.of(1));
    }

    @Test
    void test2() {
        assertThat(solver.generate(2))
                .containsExactly(List.of(1), List.of(1,1));
    }

    @Test
    void test5() {
        assertThat(solver.generate(5))
                .containsExactly(List.of(1), List.of(1,1), List.of(1,2,1), List.of(1,3,3,1), List.of(1,4,6,4,1));
    }
}