package com.github.vcvitaly._64;

public class MinimumPathSumFinder {

    public int minPathSum(int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Integer upper = upper(grid, i, j);
                Integer left = left(grid, i, j);
                if (upper == null) {
                    grid[i][j] += left;
                } else if (left == null) {
                    grid[i][j] += upper;
                } else {
                    grid[i][j] = Math.min(grid[i][j] + upper, grid[i][j] + left);
                }
            }
        }

        return grid[rows - 1][cols - 1];
    }

    private Integer upper(int[][] grid, int row, int col) {
        row--;
        return byCoordinates(grid, row, col);
    }

    private Integer left(int[][] grid, int row, int col) {
        col--;
        return byCoordinates(grid, row, col);
    }

    private Integer byCoordinates(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return null;
        }
        return grid[row][col];
    }
}
