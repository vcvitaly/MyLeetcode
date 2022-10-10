package com.github.vcvitaly._746;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MinCostClimbingStairsTest.
 *
 * @author Vitalii Chura
 */
class MinCostClimbingStairsTest {

    private MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

    @ParameterizedTest
    @MethodSource("params")
    void minCostForClimbingStairsIsFound(Param p) {
        System.out.println(p);

        int minCost = minCostClimbingStairs.minCostClimbingStairs(p.cost);

        assertThat(minCost).isEqualTo(p.minCost);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[] {10,15,20}, 15),
                Param.of(new int[] {1,100,1,1,1,100,1,1,100,1}, 6)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[] cost;
        private int minCost;
    }
}