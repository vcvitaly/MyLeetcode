package com.github.vcvitaly._1143;

import java.util.*;

// WIP
public class LcsFinder {

    public int longestCommonSubsequence(String text1, String text2) {
        final String shorter = text1.length() > text2.length() ? text2 : text1;
        final String longer = text1.length() > text2.length() ? text1 : text2;

        Map<Character, List<Integer>> longerCharPositions = charPositions(longer);
        int lcs = 0;
        //


        return -1;
    }

    private Map<Character, Integer> charCount(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }

    private Map<Character, List<Integer>> charPositions(String s) {
        final Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }
        return map;
    }

    private Queue<PositionContainer> positionContainerQueue(Map<Character, List<Integer>> charPositions) {
        final List<PositionContainer> list = charPositions.entrySet().stream()
                .map(e -> new PositionContainer(e.getValue(), e.getKey()))
                .sorted()
                .toList();
        return new LinkedList<>(list);
    }

    private record PositionContainer(List<Integer> positions, char c) implements Comparable<PositionContainer> {
        @Override
        public int compareTo(PositionContainer o) {
            return Comparator.comparingInt((PositionContainer pc) -> pc.positions().size())
                    .thenComparing(PositionContainer::c)
                    .compare(o, this);
        }
    }
}
