package com.github.vcvitaly._735;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AsteroidCollisionSolverTest {

    private AsteroidCollisionSolver solver = new AsteroidCollisionSolver();

    @Test
    void test1() {
        assertThat(solver.asteroidCollision(new int[] {5,10,-5}))
                .isEqualTo(new int[] {5,10});
    }

    @Test
    void test2() {
        assertThat(solver.asteroidCollision(new int[] {8,-8}))
                .isEqualTo(new int[] {});
    }

    @Test
    void test3() {
        assertThat(solver.asteroidCollision(new int[] {10,2,-5}))
                .isEqualTo(new int[] {10});
    }

    @Test
    void test4() {
        assertThat(solver.asteroidCollision(new int[] {1,-2,-2,-2}))
                .isEqualTo(new int[] {-2,-2,-2});
    }

    @Test
    void test5() {
        assertThat(solver.asteroidCollision(new int[] {-2,1,-1,-2}))
                .isEqualTo(new int[] {-2,-2});
    }

    @Test
    void testPerformance() {
        final int[] array = IntStream.range(0, 10).map(i -> -2).toArray();
        final int[] actual = solver.asteroidCollision(array);
        assertThat(actual)
                .isEqualTo(array);
    }
}