package com.github.vcvitaly._735;

import java.util.Objects;
import java.util.Stack;

public class AsteroidCollisionSolver {

    private static final CollisionResult FULL = new FullExplosion();

    public int[] asteroidCollision(int[] asteroids) {
        final Stack<Asteroid> s = new Stack<>();

        s.push(getAsteroid(asteroids[0]));

        for (int i = 1; i < asteroids.length; i++) {
            Asteroid current = getAsteroid(asteroids[i]);
            CollisionResult collisionResult = null;
            while (!s.isEmpty() && s.peek().movesTowards(current) && !Objects.equals(collisionResult, FULL)) {
                final Asteroid prev = s.pop();
                collisionResult = collisionResult(prev, current);
                if (collisionResult instanceof PartialExplosion(Asteroid survivedAsteroid, boolean nextWon)) {
                    current = survivedAsteroid;
                }
            }
            if (!Objects.equals(collisionResult, FULL)) {
                s.push(current);
            }
        }

        return s.stream().mapToInt(Asteroid::value).toArray();
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
