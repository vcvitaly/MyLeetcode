package com.github.vcvitaly._424;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LongestRepeatingCharacterReplacementTest.
 *
 * @author Vitalii Chura
 */
class LongestRepeatingCharacterReplacementTest {

    private LongestRepeatingCharacterReplacement characterReplacer = new LongestRepeatingCharacterReplacement();

    @ParameterizedTest
    @MethodSource("params")
    void longestSubstringContainingTheSameLetterIsFound(Param p) {
        System.out.println(p);

        int longestRepeatingSubstringWithTheSameLetter = characterReplacer.characterReplacement(p.s, p.k);

        assertThat(longestRepeatingSubstringWithTheSameLetter)
                .isEqualTo(p.lengthOfTheLongestSubstringWithTheSameLetter);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(
                        "ABAB", 2, 4
                ),
                Param.of("AABABBA", 1, 4),
                Param.of("ABBB", 2, 4),
                Param.of("BAAAB", 2, 5)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private int k;
        private int lengthOfTheLongestSubstringWithTheSameLetter;
    }
}