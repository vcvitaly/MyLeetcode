package com.github.vcvitaly._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// WIP
public class IntervalMerger {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        final List<int[]> result = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intersects(cur, intervals[i])) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                result.add(cur);
                cur = intervals[i];
            }
        }
        result.add(cur);

        return result.toArray(new int[result.size()][2]);
    }

    private boolean intersects(int[] a, int[] b) {
        return a[0] <= b[0] && a[1] >= b[0];
    }
}
