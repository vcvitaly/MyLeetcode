package com.github.vcvitaly._392;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * IsSubsequenceTest.
 *
 * @author Vitalii Chura
 */
class IsSubsequenceTest {

    private IsSubsequence isSubsequence = new IsSubsequence();

    @ParameterizedTest
    @MethodSource("params")
    void subsequenceIsFoundIfExits(Param p) {
        System.out.println(p);

        boolean isSubsequence = this.isSubsequence.isSubsequence(p.s, p.t);
        assertThat(isSubsequence).isEqualTo(p.isSubsequence);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("abc", "ahbgdc", true),
                Param.of("axc", "ahbgdc", false),
                Param.of("b", "abc", true)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String t;
        private boolean isSubsequence;
    }

}