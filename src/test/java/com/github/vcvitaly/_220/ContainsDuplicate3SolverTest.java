package com.github.vcvitaly._220;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsDuplicate3SolverTest {

    private final ContainsDuplicate3Solver solver = new ContainsDuplicate3Solver();

    @Test
    void test1() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0)
        ).isTrue();
    }

    @Test
    void test2() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3)
        ).isFalse();
    }

    @Test
    void test3() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{1,3}, 1, 2)
        ).isTrue();
    }
}