package com.github.vcvitaly._392;

/**
 * IsSubsequence.
 *
 * @author Vitalii Chura
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int subsequenceIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(subsequenceIndex)) {
                subsequenceIndex++;
                if (subsequenceIndex == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
