package com.github.vcvitaly._383;

/**
 * RansomNote.
 *
 * @author Vitalii Chura
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals(magazine)) {
            return true;
        }

        int[] ransomNoteCounts = countChars(ransomNote);
        int[] magazineCounts = countChars(magazine);

        for (int i = 0; i < ransomNoteCounts.length; i++) {
            if (ransomNoteCounts[i] > magazineCounts[i]) {
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
}
