package com.github.vcvitaly._692;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TopKFrequentWordsTest.
 *
 * @author Vitalii Chura
 */
class TopKFrequentWordsTest {

    private TopKFrequentWords topKFrequentWordsFinder = new TopKFrequentWords();

    @ParameterizedTest
    @MethodSource("params")
    void topKFrequentWordsAreFound(Param p) {
        System.out.println(p);

        List<String> topKFrequent = topKFrequentWordsFinder.topKFrequent(p.words, p.k);

        assertThat(topKFrequent).containsExactlyElementsOf(p.topKFrequentWords);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new String[] {"i","love","leetcode","i","love","coding"}, 2, List.of("i","love")),
                Param.of(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"},
                        4,List.of("the","is","sunny","day"))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String[] words;
        private int k;
        private List<String> topKFrequentWords;
    }
}