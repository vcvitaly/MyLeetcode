package com.github.vcvitaly._409;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LongestPalindromeTest.
 *
 * @author Vitalii Chura
 */
class LongestPalindromeTest {

    private LongestPalindrome longestPalindrome = new LongestPalindrome();

    @ParameterizedTest
    @MethodSource("params")
    void longestPalindromeLengthIsFound(Param p) {
        System.out.println(p);

        int longestPalindromeLength = longestPalindrome.longestPalindrome(p.s);
        assertThat(longestPalindromeLength).isEqualTo(p.longestPalindromeLength);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("abccccdd", 7),
                Param.of("a", 1),
                Param.of("Aa", 1)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private int longestPalindromeLength;
    }
}