package com.github.vcvitaly._49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GroupAnagrams.
 *
 * @author Vitalii Chura
 */
public class AnagramGrouper {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }

        return Arrays.stream(strs)
                .map(s -> new KV(strToMap(s), s))
                .collect(Collectors.groupingBy(KV::map))
                .values().stream()
                .map(kvList -> kvList.stream().map(KV::str).toList())
                .toList();
    }

    private Map<Character, Integer> strToMap(String str) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
        }
        return map;
    }

    private record KV(Map<Character, Integer> map, String str) {}
}
