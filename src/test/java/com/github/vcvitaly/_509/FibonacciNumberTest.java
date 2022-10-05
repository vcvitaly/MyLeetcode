package com.github.vcvitaly._509;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FibonacciNumberTest.
 *
 * @author Vitalii Chura
 */
class FibonacciNumberTest {

    private FibonacciNumber fibonacciNumber = new FibonacciNumber();

    @ParameterizedTest
    @MethodSource("params")
    void fibonacciNumIsFound(Param p) {
        System.out.println(p);

        int fib = fibonacciNumber.fib(p.n);

        assertThat(fib).isEqualTo(p.fibonacciNum);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(0, 0),
                Param.of(1, 1),
                Param.of(2, 1),
                Param.of(5, 5),
                Param.of(12, 144)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int n;
        private int fibonacciNum;
    }
}