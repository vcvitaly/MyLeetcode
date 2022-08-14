package com.github.vcvitaly._459;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RepeatedSubstringPatternTest.
 *
 * @author Vitalii Chura
 */
class RepeatedSubstringPatternTest {

    private RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    @ParameterizedTest
    @MethodSource("params")
    void checksWhetherAStringCanBeReconstructedFromSubstrings(Param p) {
        System.out.println(p);

        assertThat(repeatedSubstringPattern.repeatedSubstringPattern(p.s))
                .isEqualTo(p.canBeReconstructedFromSubstrings);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("abab", true),
                Param.of("aba",false),
                Param.of("abcabcabcabc", true)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public String s;
        public boolean canBeReconstructedFromSubstrings;
    }
}