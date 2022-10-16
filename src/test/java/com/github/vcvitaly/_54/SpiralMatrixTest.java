package com.github.vcvitaly._54;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SpiralMatrixTest.
 *
 * @author Vitalii Chura
 */
class SpiralMatrixTest {

    private SpiralMatrix spiralMatrix = new SpiralMatrix();

    @ParameterizedTest
    @MethodSource("params")
    void spiralOrderOfAMatrixIsReturned(Param p) {
        System.out.println(p);

        List<Integer> spiralOrder = spiralMatrix.spiralOrder(p.matrix);

        assertThat(spiralOrder).containsExactlyElementsOf(p.spiralOrder);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[][] {new int[] {1,2,3}, new int[] {4,5,6}, new int[] {7,8,9}},
                        List.of(1,2,3,6,9,8,7,4,5)),
                Param.of(new int[][] {new int[] {1,2,3,4}, new int[] {5,6,7,8}, new int[] {9,10,11,12}},
                        List.of(1,2,3,4,8,12,11,10,9,5,6,7)),
                Param.of(new int[][] {new int[] {2,3,4}, new int[] {5,6,7}, new int[] {8,9,10}, new int[] {11,12,13}, new int[] {14,15,16}},
                        List.of(2,3,4,7,10,13,16,15,14,11,8,5,6,9,12)),
                Param.of(new int[][] {new int[] {1,2,3}}, List.of(1,2,3)),
                Param.of(new int[][] {new int[] {1}, new int[] {2}, new int[] {3}}, List.of(1,2,3))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int[][] matrix;
        private List<Integer> spiralOrder;
    }
}