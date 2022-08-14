package com.github.vcvitaly._28;

/**
 * StrStr.
 *
 * @author Vitalii Chura
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean hasMatch = true;
            for (int j = i, k = 0; k < needle.length(); j++, k++) {
                if (haystack.charAt(j) != needle.charAt(k)) {
                    hasMatch = false;
                    break;
                }
            }
            if (hasMatch) {
                return i;
            }
        }

        return -1;
    }
}
