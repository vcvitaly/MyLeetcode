package com.github.vcvitaly._438;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FindAllAnagramsInAStringTest.
 *
 * @author Vitalii Chura
 */
class FindAllAnagramsInAStringTest {

    private FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();

    @ParameterizedTest
    @MethodSource("params")
    void allAnagramsInAStringAreFound(Param p) {
        System.out.println(p);

        List<Integer> anagramIndices = findAllAnagramsInAString.findAnagrams(p.s, p.p);

        assertThat(anagramIndices).containsExactlyElementsOf(p.anagramIndices);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("cbaebabacd", "abc", List.of(0, 6)),
                Param.of("abab", "ab", List.of(0, 1, 2))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String p;
        private List<Integer> anagramIndices;
    }
}