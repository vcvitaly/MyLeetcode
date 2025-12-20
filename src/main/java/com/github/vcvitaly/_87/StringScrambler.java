package com.github.vcvitaly._87;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// WIP
public class StringScrambler {

    private final Random random = new Random();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (charCounts(s1).equals(charCounts(s2))) {
            return false;
        }

        try {
            scramble(s1.toCharArray(),0, s1.length() - 1, s2);
        } catch (ScrambledException e) {
            return true;
        }

        return false;
    }

    private void scramble(char[] s1, int from, int to, String s2) {
        if (equalsIfSwappedAt(s1, 0, s2)) {
            throw new ScrambledException();
        }

        int splitIndex = random.nextInt(to - from) + from;

    }

    private Map<Character, Integer> charCounts(String s) {
        final Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.merge(c, 1, Integer::sum);
        }
        return charCounts;
    }

    private boolean equalsIfSwappedAt(char[] s1, int splitIndex, String s2) {
        for (int i = splitIndex; i < s1.length; i++) {
            if (s1[i] != s2.charAt(i - splitIndex)) {
                return false;
            }
        }
        for (int i = 0; i < splitIndex; i++) {
            if (s1[i] != s2.charAt(i + s1.length - splitIndex)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*StringScrambler ss = new StringScrambler();
        System.out.println(ss.equalsIfSwappedAt(new char[] {'a', 'b', 'c'},  0, "abc"));
        System.out.println(ss.equalsIfSwappedAt(new char[] {'a', 'b', 'c'},  1, "bca"));*/
    }

    private static class ScrambledException extends RuntimeException {}
}
