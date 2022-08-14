package com.github.vcvitaly._459;

/**
 * RepeatedSubstringPattern.
 *
 * @author Vitalii Chura
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int sLength = s.length();
        if (sLength <= 1) {
            return false;
        }

        for (int i = 1; i <= sLength/2 ; i++) {
            if (sLength % i == 0) {
                String substring = s.substring(0, i);
                int timesSubstring = sLength / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < timesSubstring; j++) {
                    sb.append(substring);
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }

        return false;
    }
}
