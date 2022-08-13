package com.github.vcvitaly._14;

public class LongestCommonPrefixFinder {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].isEmpty()) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        boolean hasCommonPrefix = true;

        while (hasCommonPrefix) {
            for (String str : strs) {
                if (i >= str.length()) {
                    hasCommonPrefix = false;
                }
            }
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
