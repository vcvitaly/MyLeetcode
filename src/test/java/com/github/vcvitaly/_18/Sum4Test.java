package com.github.vcvitaly._18;

import com.github.vcvitaly._136.SingleNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Sum4Test {

    @ParameterizedTest
    @MethodSource("params")
    void findsQuadruplesWithSumEqualToTheNumber(Param param) {
        System.out.println(param);

        Assertions.assertThat(
                Sum4.fourSum(param.nums, param.target)
        ).containsAll(param.quadruples);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(
                        new int[] {1,0,-1,0,-2,2}, 0,
                        Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-2,0,0,2), Arrays.asList(-1,0,0,1))
                ),
                Param.of(
                        new int[] {}, 0,
                        Arrays.asList(Collections.emptyList())
                )
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int[] nums;
        private int target;
        private List<List<Integer>> quadruples;
    }
}