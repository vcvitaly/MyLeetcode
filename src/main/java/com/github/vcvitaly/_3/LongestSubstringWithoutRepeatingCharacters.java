package com.github.vcvitaly._3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            boolean contains = !set.add(currentChar);
            if (contains) {
                if (set.size() > lengthOfLongestSubstring) {
                    lengthOfLongestSubstring = set.size();
                }
                set = new HashSet<>();
                set.add(currentChar);
            }
        }
        return lengthOfLongestSubstring > set.size() ? lengthOfLongestSubstring : set.size();
    }
}
