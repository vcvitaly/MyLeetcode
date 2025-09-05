package com.github.vcvitaly._352;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRangesTest {

    private final SummaryRanges summaryRanges = new SummaryRanges();

    @Test
    void test1() {
        summaryRanges.addNum(1);
        assertThat(summaryRanges.getIntervals()).isDeepEqualTo(
                new int[][]{
                        new int[]{1,1}
                }
        );
        summaryRanges.addNum(3);
        assertThat(summaryRanges.getIntervals()).isDeepEqualTo(
                new int[][]{
                        new int[]{1,1},
                        new int[]{3,3}
                }
        );
        summaryRanges.addNum(7);
        assertThat(summaryRanges.getIntervals()).isDeepEqualTo(
                new int[][]{
                        new int[]{1,1},
                        new int[]{3,3},
                        new int[]{7,7}
                }
        );
        summaryRanges.addNum(2);
        assertThat(summaryRanges.getIntervals()).isDeepEqualTo(
                new int[][]{
                        new int[]{1,3},
                        new int[]{7,7}
                }
        );
        summaryRanges.addNum(6);
        assertThat(summaryRanges.getIntervals()).isDeepEqualTo(
                new int[][]{
                        new int[]{1,3},
                        new int[]{6,7}
                }
        );
    }
}