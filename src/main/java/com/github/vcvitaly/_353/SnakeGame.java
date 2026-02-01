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
    private final SequencedSet<Coordinate> snakeBody = new LinkedHashSet<>(List.of(new Coordinate(0, 0)));
    private int foodIndex = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
    }

    public int move(String direction) {
        final Coordinate head = snakeBody.getLast();
        final int[] directionModifier = DIRECTION_MODIFIERS.get(direction);
        final Coordinate newHead = new Coordinate(head.row() + directionModifier[0], head.col() + directionModifier[1]);
        if (invalidMove(newHead)) {
            return ENDGAME;
        }
        snakeBody.add(newHead);
        if (foodIndex < food.length && newHead.row() == food[foodIndex][0] && newHead.col() == food[foodIndex][1]) {
            foodIndex++;
        } else {
            snakeBody.remove(snakeBody.getFirst());
        }

        return snakeBody.size() - 1;
    }

    private boolean invalidMove(Coordinate head) {
        return ranIntoWall(head) || snakeBody.contains(head);
    }

    private boolean ranIntoWall(Coordinate head) {
        return head.row() < 0 ||
                head.row() >= height ||
                head.col() < 0 ||
                head.col() >= width;
    }

    private record Coordinate(int row, int col) {}
}
