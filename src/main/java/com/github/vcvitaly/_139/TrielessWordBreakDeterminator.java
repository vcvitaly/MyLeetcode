package com.github.vcvitaly._139;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrielessWordBreakDeterminator implements WordBreakDeterminator {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<Character> dictChars = wordDict.stream()
                .flatMap(w -> chars(w).stream())
                .collect(Collectors.toSet());
        final Set<Character> sChars = chars(s);
        if (!dictChars.containsAll(sChars)) {
            return false;
        }
        final ArrayList<String> wordDictSorted = new ArrayList<>(wordDict);
        wordDictSorted.sort((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return -1;
            }
            if (s2.length() > s1.length()) {
                return 1;
            }
            return s1.compareTo(s2);
        });
        return wordBreak(s, 0, wordDictSorted);
    }

    private Set<Character> chars(String s) {
        final Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        return chars;
    }

    private boolean wordBreak(String s, int curCharIndex, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.startsWith(word, curCharIndex)) {
                if (word.length() == s.length() - curCharIndex) {
                    return true;
                }
                if (wordBreak(
                        s, curCharIndex + word.length(), wordDict
                )) {
                    return true;
                }
            }
        }
        return false;
    }
}
