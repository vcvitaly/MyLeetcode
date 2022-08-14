package com.github.vcvitaly._69;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SqrtCalculatorTest.
 *
 * @author Vitalii Chura
 */
class SqrtCalculatorTest {

    private SqrtCalculator sqrtCalculator = new SqrtCalculator();

    @ParameterizedTest
    @MethodSource("params")
    void findsSqrtRounded(Param p) {
        System.out.println(p);

        assertThat(sqrtCalculator.mySqrt(p.x)).isEqualTo(p.sqrtX);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(4, 2),
                Param.of(8, 2),
                Param.of(144, 12)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int x;
        private int sqrtX;
    }
}