package com.github.vcvitaly._26;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RemoveDuplicatesFromSortedArrayTest.
 *
 * @author Vitalii Chura
 */
class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray duplicatesRemover = new RemoveDuplicatesFromSortedArray();

    @ParameterizedTest
    @MethodSource("params")
    void findsMaxIndexAfterRemovingDuplicates(Param p) {
        System.out.println(p);

        assertThat(duplicatesRemover.removeDuplicatesSlow(p.nums)).isEqualTo(p.k);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[] {1,1,2}, 2),
                Param.of(new int[] {0,0,1,1,1,2,2,3,3,4}, 5),
                Param.of(new int[] {0,0,0,1},2),
                Param.of(new int[] {1}, 1),
                Param.of(new int[] {1,1}, 1)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int[] nums;
        private int k;
    }
}