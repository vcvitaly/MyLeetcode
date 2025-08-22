package com.github.vcvitaly._295;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SlowMedianFinderTest {

    private final SlowMedianFinder medianFinder = new SlowMedianFinder();

    @Test
    void test1() {
        testMedianFinder(
                Arrays.asList(1, null, 5, null),
                Arrays.asList(null, 1.0, null, 3.0)
        );
    }

    @Test
    void test2() {
        testMedianFinder(
                Arrays.asList(1, 5, null),
                Arrays.asList(null, null, 3.0)
        );
    }

    private void testMedianFinder(List<Integer> inputs, List<Double> outputs) {
        assertThat(outputs).hasSize(inputs.size());
        for (int i = 0; i < inputs.size(); i++) {
            int finalI = i;
            assertThat(inputs.get(i) == null || outputs.get(i) == null)
                    .withFailMessage(() -> "both either null or non null for index " + finalI)
                    .isTrue();
            if (inputs.get(i) != null) {
                medianFinder.addNum(inputs.get(i));
            }
            final Double output = outputs.get(i);
            if (output != null) {
                final double median = medianFinder.findMedian();
                int finalI1 = i;
                assertThat(median)
                        .withFailMessage(() -> "Expected %s, got %s at position %d"
                                .formatted(output, median, finalI1))
                        .isEqualTo(output);
            }
        }
    }
}