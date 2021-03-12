package com.github.vcvitaly._217;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ContainsDuplicateTest {

    @ParameterizedTest
    @MethodSource("params")
    void checksIfThereAreDuplicateNumbers(Param param) {
        System.out.println(param);

        Assertions.assertThat(
                ContainsDuplicates.containsDuplicate(param.nums)
        ).isEqualTo(param.containsDuplicateNumbers);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(
                        new int[] {}, false
                ),
                Param.of(
                        new int[] {1}, false
                ),
                Param.of(
                        new int[] {1,2,3,1}, true
                ),
                Param.of(
                        new int[] {1,2,3,4}, false
                ),
                Param.of(
                        new int[] {1,1,1,3,3,4,3,2,4,2}, true
                )
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int[] nums;
        private boolean containsDuplicateNumbers;
    }
}