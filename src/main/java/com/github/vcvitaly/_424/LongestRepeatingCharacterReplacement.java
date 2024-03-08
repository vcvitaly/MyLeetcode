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
        Map<Character, Integer> countMap = new HashMap<>();
        int countOfAllCharsInTheMap = 0;
        int mostFrequentCharCount = 0;
        int j = 0;
        for (int i = 0; i < s.length() - k && j < s.length() - 1; i++) {
            if (i > 0) {
                countMap.merge(s.charAt(i-1), 0, (oldVal, newVal) -> oldVal - 1);
                countOfAllCharsInTheMap--;
            }
            j = i > 0 ? i + countOfAllCharsInTheMap - 1 : i;

            while (j < s.length()) {
                char currentChar = s.charAt(j);
                countMap.merge(currentChar, 1, Integer::sum);
                countOfAllCharsInTheMap++;
                mostFrequentCharCount = countMap.values().stream().mapToInt(Integer::intValue).max().getAsInt();
                int countOfOtherCharsInTheMap = countOfAllCharsInTheMap - mostFrequentCharCount;

                if (countOfOtherCharsInTheMap > k) {
                    if (countOfAllCharsInTheMap - 1 > longestSubstringLength) {
                        longestSubstringLength = countOfAllCharsInTheMap - 1;
                    }
                    countMap.merge(currentChar, 0, (oldVal, newVal) -> oldVal - 1);
                    countOfAllCharsInTheMap--;
                    break;
                }

                j++;
            }
            if (countOfAllCharsInTheMap > longestSubstringLength) {
                longestSubstringLength = countOfAllCharsInTheMap;
            }
        }

        return longestSubstringLength;
    }
}
