package com.github.vcvitaly._295;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMedianFinderTest {

    private MedianFinder slow;
    private MedianFinder fast;

    @Test
    void randomTest() {
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            slow = new SlowMedianFinder();
            fast = new FastMedianFinder();
            final List<Integer> in = new ArrayList<>();
            final List<Double> out = new ArrayList<>();
            in.add(1);
            slow.addNum(1);
            out.add(null);
            for (int j = 0; j < 5; j++) {
                if (random.nextBoolean()) {
                    int e = random.nextInt(10);
                    in.add(e);
                    slow.addNum(e);
                    out.add(null);
                } else {
                    in.add(null);
                    out.add(slow.findMedian());
                }
            }
            in.add(null);
            out.add(slow.findMedian());
            testMedianFinder(fast, in, out, i);
        }
    }

    private void testMedianFinder(MedianFinder medianFinder, List<Integer> inputs, List<Double> outputs, int attempt) {
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
                        .withFailMessage(() -> "Expected %s, got %s at position %d and [in=%s,out=%s] at attempt %d"
                                .formatted(output, median, finalI1, inputs, outputs, attempt))
                        .isEqualTo(output);
            }
        }
    }
}
