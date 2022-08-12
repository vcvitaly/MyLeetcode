package com.github.vcvitaly._9;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * PalindromeNumberTest.
 *
 * @author Vitalii Chura
 */
class PalindromeNumberTest {

    private PalindromeNumber palindromeNumber = new PalindromeNumber();

    @ParameterizedTest
    @MethodSource("params")
    void checksForNumberBeingAPalindrome(Param param) {
        System.out.println(param);

        assertThat(palindromeNumber.isPalindrome(param.x)).isEqualTo(param.isPalindrome);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(121, true),
                Param.of(-121, false),
                Param.of(10, false)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int x;
        private boolean isPalindrome;
    }
}