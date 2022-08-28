package com.github.vcvitaly._8;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StringToIntegerTest.
 *
 * @author Vitalii Chura
 */
class StringToIntegerTest {

    private StringToInteger stringToInteger = new StringToInteger();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfStringIsCorrectlyConvertedToAnInt(Param p) {
        System.out.println(p);

        assertThat(stringToInteger.myAtoi(p.s)).isEqualTo(p.i);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("42", 42),
                Param.of("   -42", -42),
                Param.of("4193 with words", 4193),
                Param.of(" 123456789123", Integer.MAX_VALUE),
                Param.of(" +101", 101),
                Param.of(" a word 101", 0),
                Param.of("-91283472332", Integer.MIN_VALUE),
                Param.of("3.14159", 3),
                Param.of("+-12", 0),
                Param.of("00000-42a1234", 0),
                Param.of("20000000000000000000", Integer.MAX_VALUE),
                Param.of("  0000000000012345678", 12345678)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private int i;
    }
}