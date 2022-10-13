package com.github.vcvitaly._394;

import java.util.Stack;

/**
 * StringDecoder.
 *
 * @author Vitalii Chura
 */
public class StringDecoder {

    public String decodeString(String s) {
        return recursiveDecode(s);
    }

    private String recursiveDecode(String s) {
        if (consistsOfLetters(s)) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        StringBuilder numberSb = new StringBuilder();
        StringBuilder substringSb = new StringBuilder();
        int countOfOpenedBrackets = 0;
        boolean insideSubstring = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                if (insideSubstring) {
                    substringSb.append(c);
                } else {
                    numberSb.append(c);
                }
            } else if (c == '[') {
                if (insideSubstring) {
                    substringSb.append(c);
                } else {
                    insideSubstring = true;
                }
                countOfOpenedBrackets++;
            } else if (isLetter(c)) {
                if (insideSubstring) {
                    substringSb.append(c);
                } else {
                    res.append(c);
                }
            } else if (c == ']') {
                if (countOfOpenedBrackets > 1) {
                    substringSb.append(c);
                } else {
                    insideSubstring = false;
                    int times = Integer.parseInt(numberSb.toString());
                    res.append(repeat(recursiveDecode(substringSb.toString()), times));
                    numberSb = new StringBuilder();
                    substringSb = new StringBuilder();
                }
                countOfOpenedBrackets--;
            }
        }

        return res.toString();
    }

    private String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean isLetter(char c) {
        return c >= 97 && c <= 122;
    }

    private boolean consistsOfLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
