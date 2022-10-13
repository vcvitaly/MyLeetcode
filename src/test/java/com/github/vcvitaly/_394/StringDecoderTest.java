package com.github.vcvitaly._394;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StringDecoderTest.
 *
 * @author Vitalii Chura
 */
class StringDecoderTest {

    private StringDecoder stringDecoder = new StringDecoder();

    @ParameterizedTest
    @MethodSource("params")
    void decodesAString(Param p) {
        System.out.println(p);

        assertThat(stringDecoder.decodeString(p.s)).isEqualTo(p.decodedS);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("3[a]2[bc]", "aaabcbc"),
                Param.of("3[a2[c]]", "accaccacc"),
                Param.of("2[abc]3[cd]ef", "abcabccdcdcdef"),
                Param.of("3[a]", "aaa"),
                Param.of("1[a1[b1[c]]]", "abc"),
                Param.of("3[2[c]]", "cccccc")
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String decodedS;
    }
}