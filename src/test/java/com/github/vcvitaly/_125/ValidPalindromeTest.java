package com.github.vcvitaly._125;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ValidPalindromeTest.
 *
 * @author Vitalii Chura
 */
class ValidPalindromeTest {

    private ValidPalindrome validPalindrome = new ValidPalindrome();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfAStringIsAPalindromeAfterRemovingAllNonAlphaNumericChars(Param p) {
        System.out.println(p);

        assertThat(validPalindrome.isPalindrome(p.s)).isEqualTo(p.isPalindrome);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("A man, a plan, a canal: Panama", true),
                Param.of("race a car", false),
                Param.of(" ", true)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public String s;
        private boolean isPalindrome;
    }
}