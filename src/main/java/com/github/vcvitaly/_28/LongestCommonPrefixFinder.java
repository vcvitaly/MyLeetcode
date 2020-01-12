package com.github.vcvitaly._28;

public class LongestCommonPrefixFinder {

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean hasCommonPrefix = true;

        while (hasCommonPrefix) {
            for (int j = 1; hasCommonPrefix && j < strs.length ; j++) {
                if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    hasCommonPrefix = false;
                }
            }
            if (hasCommonPrefix) {
                i++;
            }
        }

        return i == 0 ? "" : strs[0].substring(0, i);
    }
}
