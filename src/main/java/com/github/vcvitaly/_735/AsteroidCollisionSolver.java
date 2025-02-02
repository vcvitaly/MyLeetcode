package com.github.vcvitaly._735;

import java.util.Objects;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class AsteroidCollisionSolver {

    public static void main(String[] args) {
        new AsteroidCollisionSolver().asteroidCollision(testData2());
    }

    private static int[] testData1() {
        return IntStream.range(0, 10_000).map(i -> -2).toArray();
    }

    private static int[] testData2() {
        final Random random = new Random();
        return IntStream.range(0, 10_000).map(i -> random.nextInt(-1000, 1000)).toArray();
    }

    private static final CollisionResult FULL = new FullExplosion();

    public int[] asteroidCollision(int[] asteroids) {
        final Stack<Asteroid> s = new Stack<>();

        s.push(getAsteroid(asteroids[0]));

        for (int i = 1; i < asteroids.length; i++) {
            Asteroid current = getAsteroid(asteroids[i]);
            CollisionResult collisionResult = null;
            while (!s.isEmpty() && s.peek().movesTowards(current) && FULL != collisionResult) {
                final Asteroid prev = s.pop();
                collisionResult = collisionResult(prev, current);
                if (collisionResult instanceof PartialExplosion(Asteroid survivedAsteroid, boolean nextWon)) {
                    current = survivedAsteroid;
                }
            }
            if (FULL != collisionResult) {
                s.push(current);
            }
        }


        final int stackSize = s.size();
        final int[] result = new int[stackSize];
        for (int i = 0; i < stackSize; i++) {
            result[stackSize - 1 - i] = s.pop().value();
        }
        return result;
    }

    private Asteroid getAsteroid(int size) {
        return new Asteroid(size);
    }

    private CollisionResult collisionResult(Asteroid prev, Asteroid next) {
        if (prev.size() == next.size()) {
            return FULL;
        }
        if (prev.size() > next.size()) {
            return new PartialExplosion(prev, false);
        }
        return new PartialExplosion(next, true);
    }

    private enum Direction {
        LEFT, RIGHT
    }

    private record Asteroid(int value) {

        public int size() {
            return Math.abs(value);
        }

        public Direction direction() {
            return value < 0 ? Direction.LEFT : Direction.RIGHT;
        }

        public boolean movesTowards(Asteroid otherAsteroid) {
            return direction() == Direction.RIGHT && otherAsteroid.direction() == Direction.LEFT;
        }
    }

    private interface CollisionResult {}

    private record PartialExplosion(Asteroid survivedAsteroid, boolean nextWon) implements CollisionResult {}

    private record FullExplosion() implements CollisionResult {}
}
