package com.github.vcvitaly._383;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RansomNoteTest.
 *
 * @author Vitalii Chura
 */
class RansomNoteTest {

    private RansomNote ransomNote = new RansomNote();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfStringRansomNoteCanBeConstructedFromStringMagazine(Param p) {
        System.out.println(p);

        assertThat(ransomNote.canConstruct(p.ransomNote, p.magazine)).isEqualTo(p.canConstruct);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("a", "b", false),
                Param.of("aa", "ab", false),
                Param.of("aa", "aab", true)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String ransomNote;
        private String magazine;
        private boolean canConstruct;
    }
}