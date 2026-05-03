package com.github.vcvitaly._63;

import java.util.Map;

import static com.github.vcvitaly._63.UniqPathsCalculator2.MoveDirection.DOWN;
import static com.github.vcvitaly._63.UniqPathsCalculator2.MoveDirection.RIGHT;

public class UniqPathsCalculator2 {

    private static final int NO_PATH = 1;
    private static final int PATH_EXISTS = 2;
    private static final Map<MoveDirection, int[]> MOVE_DIRECTIONS = Map.of(
            DOWN, new int[] {1, 0},
            RIGHT, new int[] {0, 1}
    );

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int[][] explorationGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
        final int[][] pathCount = new int[obstacleGrid.length][obstacleGrid[0].length];
        return 0;
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, int[][] explorationGrid, int[][] pathCount) {
        if (explorationGrid[row][col] == PATH_EXISTS) {
            return pathCount[row][col];
        }

        if (explorationGrid[row][col] == NO_PATH) {
            return 0;
        }

        int[] rightMove = newCoordinatesAfterMove(obstacleGrid, row, col, RIGHT);
        int[] downMove = newCoordinatesAfterMove(obstacleGrid, row, col, DOWN);

        if (rightMove != null) {

        }
        return 0;
    }

    enum MoveDirection {
        DOWN, RIGHT
    }

    private int[] newCoordinatesAfterMove(int[][] obstacleGrid, int row, int col, MoveDirection moveDirection) {
        int[] modifier = MOVE_DIRECTIONS.get(moveDirection);
        if (row + modifier[0] <=  obstacleGrid.length && col + modifier[1] <= obstacleGrid[0].length) {
            return new int[] {row + modifier[0], col + modifier[1]};
        }
        return null;
    }
}
