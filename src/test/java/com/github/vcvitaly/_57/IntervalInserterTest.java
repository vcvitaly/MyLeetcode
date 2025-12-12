package com.github.vcvitaly._57;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntervalInserterTest {

    private final IntervalInserter inserter = new IntervalInserter();

    @Test
    void test1() {
        assertThat(inserter.insert(new int[][] {{1,3},{6,9}}, new int[] {2,5}))
                .isDeepEqualTo(new int[][] {{1,5},{6,9}});
    }

    @Test
    void test2() {
        assertThat(inserter.insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8}))
                .isDeepEqualTo(new int[][] {{1,2},{3,10},{12,16}});
    }
}