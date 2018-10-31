package com.github.vcvitaly._3;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        String substring = null;
        int lengthOfLongestSubstring = 0;
        int indexStart = 0;
        for (int i = 1; i < s.length(); i++) {
            String symbol = String.valueOf(s.charAt(i));
            substring = s.substring(indexStart, i);
            boolean contains = substring.contains(symbol);
            if (contains) {
                int positionOfRepeatingCharWithinSubstr = substring.indexOf(symbol);
                indexStart += positionOfRepeatingCharWithinSubstr + 1;
            } else {
                substring += symbol;
            }

            if (substring.length() > lengthOfLongestSubstring) {
                lengthOfLongestSubstring = substring.length();
            }
        }

        return lengthOfLongestSubstring;
    }
}
