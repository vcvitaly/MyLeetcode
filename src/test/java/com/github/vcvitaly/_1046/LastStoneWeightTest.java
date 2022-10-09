package com.github.vcvitaly._1046;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LastStoneWeightTest.
 *
 * @author Vitalii Chura
 */
class LastStoneWeightTest {

    private LastStoneWeight lastStoneWeightCalculator = new LastStoneWeight();

    @ParameterizedTest
    @MethodSource("params")
    void lastStoneWeightIsFound(Param p) {
        System.out.println(p);

        int lastStoneWeight = lastStoneWeightCalculator.lastStoneWeight(p.stones);

        assertThat(lastStoneWeight).isEqualTo(p.lastStoneWeight);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[] {2,7,4,1,8,1}, 1),
                Param.of(new int[] {1}, 1)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[] stones;
        private int lastStoneWeight;
    }
}