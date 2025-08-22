package com.github.vcvitaly._435;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntervalOverlapSolver {

    public int eraseOverlapIntervals(int[][] intervals) {
        final Map<Integer, Overlap> overlaps = new HashMap<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if ( i == j) {
                    continue;
                }
                if (intervalOverlaps(intervals[i], intervals[j])) {
                    final Overlap overlap = overlaps.computeIfAbsent(i, Overlap::new);
                    overlap.overlapCount++;
                    overlap.overlappingIntervals.add(j);
                }
            }
        }

        final Queue<OverlapGroup> q = overlaps.values().stream()
                .collect(Collectors.groupingBy(o -> o.overlappingIntervals))
                .values().stream()
                .map(OverlapGroup::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedList::new));

        int intervalsToRemove = 0;
        while (!q.isEmpty()) {
            final OverlapGroup group = q.poll();

            for (Overlap overlap : group.overlaps) {
                if (overlap.overlappingIntervals.isEmpty()) {
                    continue;
                } else {
                    System.out.println("Removing overlap: " + overlap);
                    overlaps.remove(overlap.index);
                    intervalsToRemove++;
                }
                for (Integer overlappingInterval : overlap.overlappingIntervals) {
                    final Overlap otherOverlap = overlaps.get(overlappingInterval);
                    otherOverlap.overlapCount--;
                    otherOverlap.overlappingIntervals.remove(overlap.index);
                }
            }
        }

        return intervalsToRemove;
    }

    private boolean intervalOverlaps(int[] i1, int[] i2) {
        return Math.max(i1[0], i2[0]) < Math.min(i1[1], i2[1]);
    }

    private static class Overlap implements Comparable<Overlap> {
        private final int index;
        private int overlapCount = 0;
        private final Set<Integer> overlappingIntervals = new HashSet<>();

        private Overlap(int index) {
            this.index = index;
        }


        @Override
        public int compareTo(Overlap o) {
            final int countComparison = -Integer.compare(overlapCount, o.overlapCount);
            return countComparison != 0 ? countComparison : -Integer.compare(index, o.index);
        }

        @Override
        public String toString() {
            return "Overlap{" +
                    "index=" + index +
                    ", count=" + overlapCount +
                    ", overlappingIntervals=" + overlappingIntervals +
                    '}';
        }
    }

    private static class OverlapGroup implements Comparable<OverlapGroup> {
        private final List<Overlap> overlaps;

        public OverlapGroup(List<Overlap> overlaps) {
            this.overlaps = overlaps;
        }

        public int overlapCount() {
            if (overlaps.isEmpty()) {
                return 0;
            }
            return overlaps.size() * overlaps.get(0).overlapCount;
        }

        @Override
        public int compareTo(OverlapGroup o) {
            return Integer.compare(overlapCount(), o.overlapCount());
        }

        @Override
        public String toString() {
            return "OverlapGroup{" +
                    "overlaps=" + overlaps +
                    '}';
        }
    }
}
