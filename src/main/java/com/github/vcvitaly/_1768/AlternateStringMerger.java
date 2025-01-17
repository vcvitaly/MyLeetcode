package com.github.vcvitaly._1768;

public class AlternateStringMerger {

    public String mergeAlternately(String word1, String word2) {
        final StringBuilder sb = new StringBuilder();
        final int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() != word2.length()) {
            sb.append(longerWord(word1, word2).substring(min));
        }
        return sb.toString();
    }

    private String longerWord(String word1, String word2) {
        return word1.length() >= word2.length() ? word1 : word2;
    }
}
