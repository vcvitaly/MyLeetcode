package com.github.vcvitaly._724;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FindPivotIndexTest.
 *
 * @author Vitalii Chura
 */
class FindPivotIndexTest {

    private FindPivotIndex findPivotIndex = new FindPivotIndex();

    @ParameterizedTest
    @MethodSource("params")
    void pivotIndexIsFound(Param p) {
        System.out.println(p);

        int pivotIndex = findPivotIndex.pivotIndex(p.nums);
        assertThat(pivotIndex).isEqualTo(p.pivotIndex);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[] {1,7,3,6,5,6}, 3),
                Param.of(new int[] {1,2,3}, -1),
                Param.of(new int[] {2,1,-1}, 0)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[] nums;
        private int pivotIndex;
    }
}