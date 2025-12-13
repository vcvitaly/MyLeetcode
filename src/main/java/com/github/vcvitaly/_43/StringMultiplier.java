package com.github.vcvitaly._43;

// WIP
public class StringMultiplier {

    private static final int CONVERSION_MODIFIER = 48;

    public String multiply(String num1, String num2) {
        int n1 = toNumber(num1);
        int n2 = toNumber(num2);
        return toString(n1 * n2);
    }

    private int toNumber(String s) {
        int result = 0;
        int multiplier = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = toDigit(s.charAt(i));
            result += digit * multiplier;
            multiplier *= 10;
        }
        return result;
    }

    private int toDigit(char c) {
        return c - CONVERSION_MODIFIER;
    }

    private String toString(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (true) {
            if (n == 0) {
                break;
            }
            result.append(toChar(n % 10));
            n /= 10;
        }
        return result.reverse().toString();
    }

    private char toChar(int digit) {
        return (char) (digit + CONVERSION_MODIFIER);
    }
}
