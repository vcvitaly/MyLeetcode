package com.github.vcvitaly._58;

/**
 * LengthOfLastWord.
 *
 * @author Vitalii Chura
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.equals(" ") ? 0 : 1;
        }

        char[] chars = s.toCharArray();
        int size = 0;
        int lastKnownSize=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                size++;
            } else {
                if (size != 0) {
                    lastKnownSize = size;
                }
                size = 0;
            }
        }

        return size == 0 ? lastKnownSize : size;
    }
}
