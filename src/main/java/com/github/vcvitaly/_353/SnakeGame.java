package com.github.vcvitaly._353;

import java.util.*;

public class SnakeGame {

    private static final Map<String, int[]> DIRECTION_MODIFIERS = Map.of(
            "U", new int[] {-1, 0},
            "R", new int[] {0, 1},
            "D", new int[] {1, 0},
            "L", new int[] {0, -1}
    );
    private static final int ENDGAME = -1;

    private final int width;
    private final int height;
    private final int[][] food;
    private SequencedSet<int[]> snakeBody = new LinkedHashSet<>(List.of(new int[] {0, 0}));
    private int foodIndex = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
    }

    public int move(String direction) {
        final int[] head = snakeBody.getLast();
        final int[] directionModifier = DIRECTION_MODIFIERS.get(direction);
        final int[] newHead = new int[] {head[0] + directionModifier[0], head[1] + directionModifier[1]};
        if (invalidMove(newHead)) {
            return ENDGAME;
        }
        snakeBody.add(newHead);
        if (foodIndex < food.length && Arrays.equals(newHead, food[foodIndex])) {
            foodIndex++;
        } else {
            snakeBody.remove(snakeBody.getFirst());
        }

        return snakeBody.size() - 1;
    }

    private boolean invalidMove(int[] head) {
        return ranIntoWall(head) || snakeBody.contains(head);
    }

    private boolean ranIntoWall(int[] head) {
        return head[0] < 0 ||
                head[0] >= width ||
                head[1] < 0 ||
                head[1] >= height;
    }
}
