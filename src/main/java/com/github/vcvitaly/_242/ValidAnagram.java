package com.github.vcvitaly._242;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ValidAnagram.
 *
 * @author Vitalii Chura
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] sCounts = countChars(s);
        int[] tCounts = countChars(t);

        for (int i = 0; i < sCounts.length; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] countChars(String s) {
        int[] countArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countArr[getLetterPosition(s.charAt(i))-1]++;
        }
        return countArr;
    }

    private int getLetterPosition(char c) {
        return c - 96;
    }

    /*public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = toMap(s);
        Map<Character, Integer> tMap = toMap(t);
        for (Character c : sMap.keySet()) {
            if (!tMap.containsKey(c) || !Objects.equals(sMap.get(c), tMap.get(c))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }*/
}
