package com.github.vcvitaly._2336;

import java.util.ArrayList;
import java.util.List;

public class SmallestInfiniteSet {
    private final List<IntRange> ranges = new ArrayList<>(
            List.of(new IntRange(1, Integer.MAX_VALUE))
    );

    public SmallestInfiniteSet() {}

    public int popSmallest() {
        final IntRange first = ranges.getFirst();
        final int smallest = first.popSmallest();
        if (first.isEmpty()) {
            ranges.removeFirst();
        }
        return smallest;
    }

    public void addBack(int num) {
        for (int i = 0; i < ranges.size(); i++) {
            final IntRange range = ranges.get(i);
            if (range.contains(num)) {
                return;
            }
            if (range.bordersWith(num)) {
                range.addBack(num);
                return;
            }
            if (range.gt(num)) {
                ranges.add(i, new IntRange(num, num));
                return;
            }
        }
        ranges.add(new IntRange(num, num));
    }

    private static class IntRange {
        private int min;
        private int max;

        public IntRange(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean contains(int num) {
            return num >= min && num <= max;
        }

        public void addBack(int num) {
            if (atUpperBorder(num)) {
                max++;
            } else if (atLowerBorder(num)) {
                min--;
            } else {
                throw new IllegalStateException(
                        "Can't add %d back to the range [%d, %d]".formatted(num, min, max)
                );
            }
        }

        public boolean bordersWith(int num) {
            return atUpperBorder(num) || atLowerBorder(num);
        }

        public boolean gt(int num) {
            return min > num;
        }

        public int popSmallest() {
            return min++;
        }

        private boolean isEmpty() {
            return min > max;
        }

        private boolean atUpperBorder(int num) {
            return max < Integer.MAX_VALUE && num == max + 1;
        }

        private boolean atLowerBorder(int num) {
            return min > 1 && num == min - 1;
        }

        @Override
        public String toString() {
            return "IntRange{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}
