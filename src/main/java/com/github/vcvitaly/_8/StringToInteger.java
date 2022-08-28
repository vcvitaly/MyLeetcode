package com.github.vcvitaly._8;

import java.util.ArrayList;
import java.util.List;

/**
 * StringToInteger.
 *
 * @author Vitalii Chura
 */
public class StringToInteger {

    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        List<Integer> numDigits = new ArrayList<>();
        boolean isPositive = true;
        boolean isAtStringBeginning = true;
        boolean insideDigitSequence = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !isAtStringBeginning) {
                break;
            } else if (c == '-' || c == '+') {
                if (insideDigitSequence) {
                    break;
                }
                if (i+1<s.length() && !isDigit(s.charAt(i+1))) {
                    return 0;
                }
                if (c == '-') {
                    isPositive = false;
                }
            } else if (isDigit(c)) {
                numDigits.add(c - 48);
                isAtStringBeginning = false;
                insideDigitSequence = true;
            } else if (isLetter(c) || c == '.') {
                break;
            }
        }
        if (numDigits.isEmpty()) {
            return 0;
        }
        numDigits = removeLeadingZeros(numDigits);
        if (numDigits.size() > 10) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long number = 0;
        for (int i = numDigits.size() - 1, j = 0; i >= 0; i--, j++) {
            number += (long) numDigits.get(i) * powOfTen(j);
        }
        if (isPositive && number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (!isPositive) {
            number = -number;
            if (number < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) number;
    }

    private boolean isDigit(char c) {
        return (c >= 48 && c <= 57);
    }

    private boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    private int powOfTen(int n) {
        if (n == 0) {
            return 1;
        }
        int tenInNthPower = 10;
        for (int i = 1; i < n; i++) {
            tenInNthPower *= 10;
        }
        return tenInNthPower;
    }

    private List<Integer> removeLeadingZeros(List<Integer> digits) {
        boolean insideNonZeroSequence = false;
        List<Integer> trimmedDigits = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            Integer digit = digits.get(i);
            if (digit > 0) {
                trimmedDigits.add(digit);
                insideNonZeroSequence = true;
            } else {
                if (insideNonZeroSequence) {
                    trimmedDigits.add(digit);
                }
            }
        }
        return trimmedDigits;
    }
}
