package com.github.vcvitaly._844;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BackspaceStringCompareTest.
 *
 * @author Vitalii Chura
 */
class BackspaceStringCompareTest {

    private BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();

    @ParameterizedTest
    @MethodSource("params")
    void correctComparisonResultIsReturned(Param p) {
        System.out.println(p);

        boolean comparisonResult = backspaceStringCompare.backspaceCompare(p.s, p.t);

        assertThat(comparisonResult).isEqualTo(p.areEqual);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("ab#c", "ad#c", true),
                Param.of("ab##", "c#d#", true),
                Param.of("a#c", "b", false),
                Param.of("xywrrmp", "xywrrmu#p", true)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String t;
        private boolean areEqual;
    }
}