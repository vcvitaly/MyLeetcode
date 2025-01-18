package com.github.vcvitaly._1456;

public class MaxVowelNumberFinder {
    public int maxVowels(String s, int k) {
        int maxVowelNumber = 0;
        int currentWindowVowelNumber = 0;
        for (int i = 0, j = 1; i < s.length(); i++) {
            final boolean isVowel = isVowel(s.charAt(i));
            if (j <= k) {
                if (isVowel) {
                    currentWindowVowelNumber++;
                }
                j++;
            } else {
                if (isVowel(s.charAt(i - k))) {
                    currentWindowVowelNumber--;
                }
                if (isVowel) {
                    currentWindowVowelNumber++;
                }
            }
            if (currentWindowVowelNumber > maxVowelNumber) {
                maxVowelNumber = currentWindowVowelNumber;
            }
        }
        return maxVowelNumber;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
