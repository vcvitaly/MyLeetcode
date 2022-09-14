package com.github.vcvitaly._2133;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CheckIfEveryRowAndColumnContainsAllNumbersTest.
 *
 * @author Vitalii Chura
 */
class CheckIfEveryRowAndColumnContainsAllNumbersTest {

    private CheckIfEveryRowAndColumnContainsAllNumbers check = new CheckIfEveryRowAndColumnContainsAllNumbers();

    @ParameterizedTest
    @MethodSource("params")
    void everyRowAndColumnContainsAllNumbers(Param p) {
        System.out.println(p);

        boolean isValid = check.checkValid(p.matrix);
        assertThat(isValid).isEqualTo(p.containsAllNumbers);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[][] {new int[]{1,2,3}, new int[]{3,1,2}, new int[]{2,3,1}}, true),
                Param.of(new int[][] {new int[]{2,2,2}, new int[]{2,2,2}, new int[]{2,2,2}}, false)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[][] matrix;
        private boolean containsAllNumbers;
    }
}