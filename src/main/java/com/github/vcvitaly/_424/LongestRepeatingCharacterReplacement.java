package com.github.vcvitaly._424;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestRepeatingCharacterReplacement.
 *
 * @author Vitalii Chura
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s.length() <= 1) {
            return s.length();
        }

        int longestSubstringLength = 0;
        for (int i = 0; i < s.length() - k; i++) {
            int countOfReplacementsLeft = k;
            int j = i;
            Map<Character, Integer> map = new HashMap<>();
            int mostFrequentCharCount = 0;
            int countOfAllCharsInTheMap = 0;
            while (j < s.length()) {
                char currentChar = s.charAt(j);
                map.merge(currentChar, 1, Integer::sum);
                int count = map.get(currentChar);
                if (count > mostFrequentCharCount) {
                    mostFrequentCharCount = count;
                } else {
                    if (countOfReplacementsLeft > 0) {
                        countOfReplacementsLeft--;
                    } else {
                        break;
                    }
                }
                countOfAllCharsInTheMap++;
                j++;
            }
            if (countOfAllCharsInTheMap > longestSubstringLength) {
                longestSubstringLength = countOfAllCharsInTheMap;
            }
        }

        return longestSubstringLength;
    }
}
