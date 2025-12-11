package com.github.vcvitaly._56;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntervalMergerTest {

    private final IntervalMerger intervalMerger = new IntervalMerger();

    @Test
    void test1() {
        assertThat(intervalMerger.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}))
                .isDeepEqualTo(new int[][] {{1,6},{8,10},{15,18}});
    }

    @Test
    void test2() {
        assertThat(intervalMerger.merge(new int[][] {{1,4},{4,5}}))
                .isDeepEqualTo(new int[][] {{1,5}});
    }

    @Test
    void test3() {
        assertThat(intervalMerger.merge(new int[][] {{4,7},{1,4}}))
                .isDeepEqualTo(new int[][] {{1,7}});
    }

    @Test
    void test4() {
        assertThat(intervalMerger.merge(new int[][] {{1,4}}))
                .isDeepEqualTo(new int[][] {{1,4}});
    }

    @Test
    void test5() {
        assertThat(intervalMerger.merge(new int[][] {{1,1},{1,1}}))
                .isDeepEqualTo(new int[][] {{1,1}});
    }

    @Test
    void test6() {
        assertThat(intervalMerger.merge(new int[][] {{1,3},{1,1}}))
                .isDeepEqualTo(new int[][] {{1,3}});
    }
}