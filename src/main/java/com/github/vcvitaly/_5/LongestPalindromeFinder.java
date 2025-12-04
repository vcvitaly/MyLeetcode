package com.github.vcvitaly._5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromeFinder {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        final Map<Character, List<Integer>> charIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charIndexes.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }
        int maxLength = 0;
        int from = 0;
        int to = 0;
        for (int leftIndex = 0; leftIndex < s.length(); leftIndex++) {
            char c = s.charAt(leftIndex);
            final List<Integer> cIndexes = charIndexes.get(c);
            for (int j = cIndexes.size() - 1; j > 0; j--) {
                final int rightIndex = cIndexes.get(j);
                int substrL = rightIndex - leftIndex + 1;
                if (substrL > maxLength && isPalindrome(s, leftIndex, rightIndex)) {
                    maxLength = substrL;
                    from = leftIndex;
                    to = rightIndex;
                    break;
                }
            }
        }

        return s.substring(from, to  + 1);
    }

    private boolean isPalindrome(String s, int from, int to) {
        if (from == to) {
            return true;
        }

        while (s.charAt(from)
                == s.charAt(to) && from <= to) {
            from++;
            to--;
        }
        return from == to || from == to + 1 || from == to + 2;
    }
}
