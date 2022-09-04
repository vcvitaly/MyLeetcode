package com.github.vcvitaly._205;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * IsomorphicStringTest.
 *
 * @author Vitalii Chura
 */
class IsomorphicStringTest {

    private IsomorphicString isomorphicString = new IsomorphicString();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfStringsAreIsomorphic(Param p) {
        System.out.println(p);

        assertThat(isomorphicString.isIsomorphic(p.s, p.t)).isEqualTo(p.isIsomorphic);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("egg", "add", true),
                Param.of("foo", "bar", false),
                Param.of("paper", "title", true),
                Param.of("bbbaaaba", "aaabbbba", true)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String t;
        private boolean isIsomorphic;
    }
}