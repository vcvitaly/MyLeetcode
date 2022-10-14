package com.github.vcvitaly._43;

/**
 * MultiplyStrings.
 *
 * @author Vitalii Chura
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        return String.valueOf(toInt(num1) * toInt(num2));
    }

    private int toInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res*10 + toDigit(s.charAt(i));
        }
        return res;
    }

    private int toDigit(char c) {
        return c - 48;
    }
}
