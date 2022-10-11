package com.github.vcvitaly._62;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * UniquePathsTest.
 *
 * @author Vitalii Chura
 */
class UniquePathsTest {

    private UniquePaths uniquePaths = new UniquePaths();

    @ParameterizedTest
    @MethodSource("params")
    void countOfUniquePathsIsFound(Param p) {
        System.out.println(p);

        int countOfUniquePaths = uniquePaths.uniquePaths(p.n, p.m);

        assertThat(countOfUniquePaths).isEqualTo(p.countOfUniquePaths);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(2, 2, 2),
                Param.of(3, 2, 3),
                Param.of(3, 7, 28)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int m,n,countOfUniquePaths;
    }
}