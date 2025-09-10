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
    void test2_1() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 3, 0)
        ).isTrue();
    }

    @Test
    void test3() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{1,3}, 1, 2)
        ).isTrue();
    }

    @Test
    void test4() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{-2,3}, 2, 5)
        ).isTrue();
    }

    @Test
    void test5() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{1,2,2,3,4,5}, 3, 0)
        ).isTrue();
    }

    @Test
    void test6() {
        assertThat(
                solver.containsNearbyAlmostDuplicate(new int[]{7,1,3}, 2, 3)
        ).isTrue();
    }
}