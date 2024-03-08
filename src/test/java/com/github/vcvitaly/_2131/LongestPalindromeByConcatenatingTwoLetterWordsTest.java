package com.github.vcvitaly._2131;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LongestPalindromeByConcatenatingTwoLetterWordsTest.
 *
 * @author Vitalii Chura
 */
class LongestPalindromeByConcatenatingTwoLetterWordsTest {

    private LongestPalindromeByConcatenatingTwoLetterWords palindromeLengthCalculator =
            new LongestPalindromeByConcatenatingTwoLetterWords();

    @ParameterizedTest
    @MethodSource("params")
    void longestPalindromeLengthIsFound(Param p) {
        System.out.println(p);

        int longestPalindromeLength = palindromeLengthCalculator.longestPalindrome(p.words);

        assertThat(longestPalindromeLength).isEqualTo(p.longestPalindromeLength);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new String[] {"lc","cl","gg"}, 6),
                Param.of(new String[] {"ab","ty","yt","lc","cl","ab"}, 8),
                Param.of(new String[] {"cc","ll","xx"}, 2),
                Param.of(new String[] {"ab"}, 0),
                Param.of(new String[] {"aa"}, 2),
                Param.of(new String[] {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}, 22),
                Param.of(new String[] {"nn","nn","hg","gn","nn","hh","gh","nn","nh","nh"}, 14)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String[] words;
        private int longestPalindromeLength;
    }
}