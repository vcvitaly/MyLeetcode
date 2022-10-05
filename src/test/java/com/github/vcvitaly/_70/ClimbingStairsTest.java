package com.github.vcvitaly._70;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * ClimbingStairsTest.
 *
 * @author Vitalii Chura
 */
class ClimbingStairsTest {

    private ClimbingStairs climbingStairs = new ClimbingStairs();

    @ParameterizedTest
    @MethodSource("params")
    void numberOfWaysToReachTopStairIsFound(Param p) {
        System.out.println(p);

        int countOfWaysToReachTheTopStair = climbingStairs.climbStairs(p.numsOfStairs);

        assertThat(countOfWaysToReachTheTopStair).isEqualTo(p.countOfWaysToReachTheTopStair);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(2, 2),
                Param.of(3, 3),
                Param.of(1, 1)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int numsOfStairs;
        private int countOfWaysToReachTheTopStair;
    }
}