package com.github.vcvitaly._17;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LetterCombinationsOfAPhoneNumberTest.
 *
 * @author Vitalii Chura
 */
class LetterCombinationsOfAPhoneNumberTest {

    private LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();


    @ParameterizedTest
    @MethodSource("params")
    void letterCombinationsAreReturned(Param p) {
        System.out.println(p);

        assertThat(letterCombinationsOfAPhoneNumber.letterCombinations(p.digits))
                .containsExactlyInAnyOrderElementsOf(p.letterCombinations);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("23", List.of("ad","ae","af","bd","be","bf","cd","ce","cf")),
                Param.of("", Collections.emptyList()),
                Param.of("2", List.of("a","b","c"))

        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String digits;
        private List<String> letterCombinations;
    }
}