package com.github.vcvitaly._299;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BullsAndCowsTest.
 *
 * @author Vitalii Chura
 */
class BullsAndCowsTest {

    private BullsAndCows bullsAndCows = new BullsAndCows();

    @ParameterizedTest
    @MethodSource("params")
    void hintIsGenerated(Param p) {
        System.out.println(p);

        String hint = bullsAndCows.getHint(p.secret, p.guess);

        assertThat(hint).isEqualTo(p.hint);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("1807", "7810", "1A3B"),
                Param.of("1123", "0111", "1A1B"),
                Param.of("11", "10", "1A0B")
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String secret;
        private String guess;
        private String hint;
    }
}