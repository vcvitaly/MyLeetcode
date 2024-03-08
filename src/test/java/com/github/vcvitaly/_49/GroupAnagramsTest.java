package com.github.vcvitaly._49;

import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * GroupAnagramsTest.
 *
 * @author Vitalii Chura
 */
class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams = new GroupAnagrams();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfAnagramsArePropertyGrouped(Param p) {
        System.out.println(p);

        List<List<String>> anagramsGrouped = groupAnagrams.groupAnagrams(p.strs);

        for (int i = 0; i < p.strsGrouped.size(); i++) {
            assertThat(anagramsGrouped.get(i)).containsExactlyElementsOf(p.strsGrouped.get(i));
        }
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new String[]{"eat","tea","tan","ate","nat","bat"},
                        List.of(List.of("bat"), List.of("nat","tan"), List.of("ate","eat","tea"))),
                Param.of(new String[]{""}, List.of(List.of(""))),
                Param.of(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String[] strs;
        private List<List<String>> strsGrouped;
    }
}