package com.github.vcvitaly._2390;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RemovingStarsFromAStringTest.
 *
 * @author Vitalii Chura
 */
class RemovingStarsFromAStringTest {

    private RemovingStarsFromAString removingStarsFromAString = new RemovingStarsFromAString();

    @ParameterizedTest
    @MethodSource("params")
    void starsAreRemovedFromAString(Param p) {
        System.out.println(p);

        String sWithRemovedStars = removingStarsFromAString.removeStars(p.s);
        assertThat(sWithRemovedStars).isEqualTo(p.sWithRemovedStars);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of("leet**cod*e", "lecoe"),
                Param.of("erase*****", ""),
                Param.of("abb*cdfg*****x*", "a"),
                Param.of("a*", "")
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String s;
        private String sWithRemovedStars;
    }
}