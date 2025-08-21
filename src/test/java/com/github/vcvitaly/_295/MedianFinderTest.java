package com.github.vcvitaly._295;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MedianFinderTest {

    private final MedianFinder medianFinder = new MedianFinder();

    @Test
    void test1() {
        testMedianFinder(
                Arrays.asList(1, 2, null, 3, null),
                Arrays.asList(null, null, 1.5, null, 2.0)
        );
    }

    @Test
    void test2() {
        testMedianFinder(
                Arrays.asList(1, null),
                Arrays.asList(null, 1.0)
        );
    }

    @Test
    void test3() {
        testMedianFinder(
                Arrays.asList(1, 1, null),
                Arrays.asList(null, null, 1.0)
        );
    }

    @Test
    void test4() {
        testMedianFinder(
                Arrays.asList(1, 2, 3, 4, 5, null),
                Arrays.asList(null, null, null, null, null, 3.0)
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
            if (outputs.get(i) != null) {
                assertThat(medianFinder.findMedian()).isEqualTo(outputs.get(i));
            }
        }
    }
}