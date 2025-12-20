package com.github.vcvitaly._171;

public class ExcelColNumCalculator {

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int pow = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            final char c = columnTitle.charAt(i);
            final int val = val(c);
            number += ((int) Math.pow(26, pow)) * val;
            pow++;
        }
        return number;
    }

    private int val(char ch) {
        return ch - 'A' + 1;
    }
}
