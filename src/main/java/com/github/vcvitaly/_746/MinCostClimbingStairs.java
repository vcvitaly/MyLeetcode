package com.github.vcvitaly._746;

/**
 * MinCostClimbingStairs.
 *
 * @author Vitalii Chura
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return 1;
        }

        int[][] grid = new int[2][cost.length+1];
        grid[0][0] = 0;
        grid[0][1] = cost[0];
        grid[1][0] = 0;
        grid[1][1] = 0;
        grid[1][2] = cost[1];

        for (int j = 2; j < cost.length+1; j++) {
            grid[0][j] = computeNewValue(grid, cost, 0, j);
        }
        for (int j = 3; j < cost.length+1; j++) {
            grid[1][j] = computeNewValue(grid, cost, 1, j);
        }

        return Math.min(grid[0][grid[0].length-1], grid[1][grid[0].length-1]);
    }

    private int computeNewValue(int[][] grid, int[] cost, int i, int j) {
        return Math.min(grid[i][j-1] + cost[j-1], grid[i][j-2] + cost[j-2]);
    }
}
