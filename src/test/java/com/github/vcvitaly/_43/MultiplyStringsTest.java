package com.github.vcvitaly._43;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MultiplyStringsTest.
 *
 * @author Vitalii Chura
 */
class MultiplyStringsTest {

    private MultiplyStrings multiplyStrings = new MultiplyStrings();

    @ParameterizedTest
    @MethodSource("params")
    void stringMultiplicationResultIsFound(Param p) {
        System.out.println(p);

        String actualResult = multiplyStrings.multiply(p.num1, p.num2);

        assertThat(actualResult).isEqualTo(p.result);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("2", "3", "6"),
                Param.of("123","456", "56088")
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public String num1;
        public String num2;
        public String result;
    }
}