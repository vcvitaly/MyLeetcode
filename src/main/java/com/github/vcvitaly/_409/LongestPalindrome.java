package com.github.vcvitaly._409;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestPalindrome.
 *
 * @author Vitalii Chura
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.merge(s.charAt(i), 1, Integer::sum);
        }

        int maxLength = 0;
        int leftOver = 0;
        for (Integer value : countMap.values()) {
            if (value % 2 == 0) {
                maxLength += value;
            } else {
                maxLength += value - 1;
                leftOver++;
            }
        }

        if (leftOver > 0) {
            maxLength++;
        }

        return maxLength;
    }
}
