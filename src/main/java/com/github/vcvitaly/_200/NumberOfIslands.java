package com.github.vcvitaly._200;

/**
 * NumberOfIslands.
 *
 * @author Vitalii Chura
 */
public class NumberOfIslands {

    private static final char WATER = '0';
    private static final char EARTH = '1';

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == EARTH) {
                        dfs(grid, visited, i, j);
                        numIslands++;
                    } else {
                        visited[i][j] = true;
                    }
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
        visited[i][j] || grid[i][j] == WATER) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i, j-1);
    }
}
