package com.github.vcvitaly._2042;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CheckIfNumbersAreAscendingInASentenceTest.
 *
 * @author Vitalii Chura
 */
class CheckIfNumbersAreAscendingInASentenceTest {

    private CheckIfNumbersAreAscendingInASentence checkNumbers = new CheckIfNumbersAreAscendingInASentence();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfNumbersAreAscendingInASentence(Param p) {
        System.out.println(p);

        boolean areNumbersAscending = checkNumbers.areNumbersAscending(p.s);
        assertThat(areNumbersAscending).isEqualTo(p.areNumbersIncreasing);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("1 box has 3 blue 4 red 6 green and 12 yellow marbles", true),
                Param.of("hello world 5 x 5", false),
                Param.of("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s", false)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private boolean areNumbersIncreasing;
    }
}