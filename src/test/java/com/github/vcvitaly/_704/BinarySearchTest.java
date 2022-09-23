package com.github.vcvitaly._704;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BinarySearchTest.
 *
 * @author Vitalii Chura
 */
class BinarySearchTest {

    private BinarySearch binarySearch = new BinarySearch();

    @ParameterizedTest
    @MethodSource("params")
    void targetIndexIsFound(Param p) {
        System.out.println(p);

        int index = binarySearch.search(p.nums, p.target);
        assertThat(index).isEqualTo(p.index);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[] {-1,0,3,5,9,12}, 9, 4),
                Param.of(new int[] {-1,0,3,5,9,12}, 2,-1),
                Param.of(new int[] {5}, 5, 0)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[] nums;
        private int target;
        private int index;
    }
}