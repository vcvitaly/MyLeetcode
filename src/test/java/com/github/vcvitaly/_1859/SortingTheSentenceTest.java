package com.github.vcvitaly._1859;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SortingTheSentenceTest.
 *
 * @author Vitalii Chura
 */
class SortingTheSentenceTest {

    private SortingTheSentence sortingTheSentence = new SortingTheSentence();

    @ParameterizedTest
    @MethodSource("params")
    void sentenceIsReconstructedFromS(Param p) {
        System.out.println(p);

        String reconstructedSentence = sortingTheSentence.sortSentence(p.s);

        assertThat(reconstructedSentence).isEqualTo(p.reconstructedSentence);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("is2 sentence4 This1 a3", "This is a sentence"),
                Param.of("Myself2 Me1 I4 and3", "Me Myself and I")
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String reconstructedSentence;
    }
}