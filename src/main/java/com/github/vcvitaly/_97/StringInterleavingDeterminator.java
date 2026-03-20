package com.github.vcvitaly._97;

import java.util.*;
import java.util.stream.Collectors;

// WIP
public class StringInterleavingDeterminator {

    public boolean isInterleave(String s1, String s2, String s3) {
        final Map<Character, Queue<Integer>> positions = new HashMap<>();
        for (int i = 0; i < s3.length(); i++) {
            final char c = s3.charAt(i);
            positions.computeIfAbsent(c, k -> new LinkedList<>()).add(i);
        }

        for (int i = 0; i < s1.length(); i++) {
            final char c = s1.charAt(i);
            final Queue<Integer> q = positions.get(c);
            if (q != null && !q.isEmpty()) {
                q.poll();
            } else {
                return false;
            }
        }

        final String leftover = positions.entrySet().stream()
                .flatMap(e -> e.getValue().stream()
                        .map(pos -> new LetterPosition(e.getKey(), pos))
                ).sorted(Comparator.comparing(LetterPosition::position))
                .map(LetterPosition::c)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return leftover.equals(s2);
    }

    private record LetterPosition(char c, int position) {}
}
