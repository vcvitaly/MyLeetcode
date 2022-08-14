package com.github.vcvitaly._58;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LengthOfLastWordTest.
 *
 * @author Vitalii Chura
 */
class LengthOfLastWordTest {

    private LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    @ParameterizedTest
    @MethodSource("params")
    void findTheLengthOfTheLastWordInAString(Param p) {
        System.out.println(p);

        assertThat(lengthOfLastWord.lengthOfLastWord(p.s)).isEqualTo(p.lengthOfTheLastWord);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("Hello World", 5),
                Param.of("   fly me   to   the moon  ", 4),
                Param.of("luffy is still joyboy", 6),
                Param.of("", 0),
                Param.of(" ", 0),
                Param.of("a", 1),
                Param.of(" a", 1),
                Param.of("a ", 1),
                Param.of("aa a", 1)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public String s;
        private int lengthOfTheLastWord;
    }
}