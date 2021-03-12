package com.github.vcvitaly._136;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SingleNumberTest {

    @ParameterizedTest
    @MethodSource("params")
    void findsTheNumberWhichOccursOnce(Param param) {
        System.out.println(param);

        Assertions.assertThat(
                SingleNumber.singleNumber(param.nums)
        ).isEqualTo(param.number);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(
                        new int[] {2,2,1}, 1
                ),
                Param.of(
                        new int[] {4,1,2,1,2}, 4
                ),
                Param.of(
                        new int[] {1}, 1
                )
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int[] nums;
        private int number;
    }
}