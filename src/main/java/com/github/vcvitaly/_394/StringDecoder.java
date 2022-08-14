package com.github.vcvitaly._394;

/**
 * StringDecoder.
 *
 * @author Vitalii Chura
 */
public class StringDecoder {

    public String decodeString(String s) {
        StringBuilder numberSb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {

            } else if (c == '[') {

            } else if (isLetter(c)) {

            } else if (c == ']') {

            }
        }

        return "";
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

    private static class Node {
        private int number;
        private String s;
    }
}
