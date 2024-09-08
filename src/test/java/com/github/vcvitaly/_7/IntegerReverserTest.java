package com.github.vcvitaly._7;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerReverserTest {

    private final IntegerReverser reverser = new IntegerReverser();

    @ParameterizedTest
    @MethodSource("getParams")
    void integerIsReversed(int input, int expected) {
        assertThat(reverser.reverse(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21),
                Arguments.of(1, 1),
                Arguments.of(0, 0),
                Arguments.of(123_456_789_3, 0),
                Arguments.of(-7, -7),
                Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(1463847412, 2147483641)
        );
    }
}