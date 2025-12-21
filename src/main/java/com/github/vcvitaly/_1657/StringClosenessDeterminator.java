package com.github.vcvitaly._1657;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// WIP 15 min left
public class StringClosenessDeterminator {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        final Map<Character, Integer> charCounts1 = charCounts(word1);
        final Map<Character, Integer> charCounts2 = charCounts(word2);

        if (!Set.copyOf(charCounts1.values())
                .equals(Set.copyOf(charCounts2.values()))
        ) {
            return false;
        }



        return false;
    }

    private Map<Character, Integer> charCounts(String s) {
        final Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            m.merge(s.charAt(i), 1, Integer::sum);
        }
        return m;
    }
}
