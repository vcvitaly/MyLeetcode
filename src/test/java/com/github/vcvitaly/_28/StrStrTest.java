package com.github.vcvitaly._28;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StrStrTest.
 *
 * @author Vitalii Chura
 */
class StrStrTest {

    private StrStr strStr = new StrStr();

    @ParameterizedTest
    @MethodSource("params")
    void findsIndexOfStringInAnotherString(Param p) {
        System.out.println(p);

        assertThat(strStr.strStr(p.haystack, p.needle)).isEqualTo(p.i);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("hello", "ll", 2),
                Param.of("aaaaa","bba", -1),
                Param.of("mississippi", "mississippi", 0),
                Param.of("aaaa", "aaaa", 0),
                Param.of("A plan", "plan", 2)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public String haystack;
        public String needle;
        public int i;
    }
}