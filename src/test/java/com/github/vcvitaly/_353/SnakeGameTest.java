package com.github.vcvitaly._353;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SnakeGameTest {

    private SnakeGame snakeGame;

    @Test
    void test1() {
        snakeGame = new SnakeGame(3, 2, new int[][] {{1,2}, {0,1}});
        runTestHarness(
                new String[] {"R", "D", "R", "U", "L", "U"},
                List.of(0, 0, 1, 1, 2, -1)
        );
    }

    @Test
    void test2() {
        snakeGame = new SnakeGame(3, 3, new int[][] {{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
        runTestHarness(
                new String[] {"D","D","R","U","U","L","D","R","R","U","L","L","D","R","U"},
                List.of(0,1,1,1,1,2,2,2,2,3,4,4,4,4,-1)
        );
    }

    private void runTestHarness(String[] directions, List<Integer> output) {
        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            Integer expected = output.get(i);
            int finalI = i;
            int actual = snakeGame.move(direction);
            assertThat(actual)
                    .withFailMessage(() -> "Expected score %d after move %s at step %d but was %d".formatted(expected, direction, finalI, actual))
                    .isEqualTo(expected);
        }
    }
}