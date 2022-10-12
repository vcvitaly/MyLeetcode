package com.github.vcvitaly._424;

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

        return Math.max(characterReplacementOneWay(s, k),
                characterReplacementOneWay(new StringBuilder(s).reverse().toString(), k));
    }

    private int characterReplacementOneWay(String s, int k) {
        int longestSubstringLength = 0;
        int countOfReplacementsLeft;
        for (int i = 0; i < s.length() - k; i++) {
            char substringStartingChar = s.charAt(i);
            countOfReplacementsLeft = k;
            int substringLength = 0;
            int j = i;
            while (j < s.length()) {
                if (s.charAt(j) != substringStartingChar) {
                    if (countOfReplacementsLeft == 0) {
                        break;
                    }
                    countOfReplacementsLeft--;
                }
                substringLength++;
                j++;
            }
            if (substringLength > longestSubstringLength) {
                longestSubstringLength = substringLength;
            }
        }

        return longestSubstringLength;
    }
}
