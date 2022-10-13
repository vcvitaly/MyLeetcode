package com.github.vcvitaly._202;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HappyNumberTest.
 *
 * @author Vitalii Chura
 */
class HappyNumberTest {

    private HappyNumber happyNumber = new HappyNumber();

    @ParameterizedTest
    @MethodSource("params")
    void numberHappinessIsVerified(Param p) {
        System.out.println(p);

        boolean isHappy = happyNumber.isHappy(p.n);

        assertThat(isHappy).isEqualTo(p.isHappyNumber);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(19, true),
                Param.of(2, false)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int n;
        private boolean isHappyNumber;
    }
}