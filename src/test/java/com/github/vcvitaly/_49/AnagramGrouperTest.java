package com.github.vcvitaly._49;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * GroupAnagramsTest.
 *
 * @author Vitalii Chura
 */
class AnagramGrouperTest {

    private AnagramGrouper groupAnagrams = new AnagramGrouper();

    @Test
    void test1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> anagramsGrouped = groupAnagrams.groupAnagrams(strs);

        assertThat(
                anagramsGrouped.stream().map(Set::copyOf).collect(Collectors.toSet())
        ).containsExactlyInAnyOrderElementsOf(
                Set.of(Set.of("bat"), Set.of("nat", "tan"), Set.of("ate", "eat", "tea"))
        );
    }

    @Test
    void test2() {
        String[] strs = {""};

        List<List<String>> anagramsGrouped = groupAnagrams.groupAnagrams(strs);

        assertThat(anagramsGrouped).containsExactlyElementsOf(List.of(List.of("")));
    }

    @Test
    void test3() {
        String[] strs = {"a"};

        List<List<String>> anagramsGrouped = groupAnagrams.groupAnagrams(strs);

        assertThat(anagramsGrouped).containsExactlyElementsOf(List.of(List.of("a")));
    }
}