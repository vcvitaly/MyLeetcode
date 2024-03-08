package com.github.vcvitaly._1706;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * WhereWillTheBallFallTest.
 *
 * @author Vitalii Chura
 */
class WhereWillTheBallFallTest {

    private WhereWillTheBallFall whereWillTheBallFall = new WhereWillTheBallFall();

    @ParameterizedTest
    @MethodSource("params")
    void columnsWhereTheBallWillFallAreFound(Param p) {
        System.out.println(p);

        int[] answer = whereWillTheBallFall.findBall(p.grid);

        assertThat(answer).containsExactly(p.answer);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new int[][] {new int[] {1,1,1,-1,-1}, new int[] {1,1,1,-1,-1}, new int[] {-1,-1,-1,1,1},
                        new int[] {1,1,1,1,-1}, new int[] {-1,-1,-1,-1,-1}},
                        new int[] {1,-1,-1,-1,-1}),
                Param.of(new int[][] {new int[] {-1}}, new int[] {-1}),
                Param.of(new int[][] {new int[] {1,1,1,1,1,1}, new int[] {-1,-1,-1,-1,-1,-1}, new int[] {1,1,1,1,1,1},
                        new int[] {-1,-1,-1,-1,-1,-1}},
                        new int[] {0,1,2,3,4,-1})
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[][] grid;
        private int[] answer;
    }
}