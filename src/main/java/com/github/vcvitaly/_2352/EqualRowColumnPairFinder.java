package com.github.vcvitaly._2352;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowColumnPairFinder {

    public int equalPairs(int[][] grid) {
        final Map<Integer, IdentityCounter> map = new HashMap<>();

        for (final int[] row : grid) {
            map.computeIfAbsent(Arrays.toString(row).hashCode(), k -> new IdentityCounter()).rowCount++;
        }

        final int[] column = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                column[j] = grid[j][i];
            }
            map.computeIfAbsent(Arrays.toString(column).hashCode(), k -> new IdentityCounter()).colCount++;
        }

        return map.values().stream()
                .mapToInt(ic -> ic.rowCount * ic.colCount)
                .sum();
    }

    private static class IdentityCounter {
        private int rowCount;
        private int colCount;
    }
}
