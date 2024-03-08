package com.github.vcvitaly._33;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SearchInRotatedSortedArrayTest.
 *
 * @author Vitalii Chura
 */
class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();

    @ParameterizedTest
    @MethodSource("params")
    void targetIndexIsReturned(Param p) {
        System.out.println(p);

        int targetIndex = search.search(p.nums, p.target);
        assertThat(targetIndex).isEqualTo(p.targetIndex);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[] {4,5,6,7,0,1,2}, 0, 4),
                Param.of(new int[] {4,5,6,7,0,1,2}, 3, -1),
                Param.of(new int[] {1}, 0, -1)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[] nums;
        private int target;
        private int targetIndex;
    }
}