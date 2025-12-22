package com.github.vcvitaly._38;

public class CountSaySeqFinder {

    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }
        s = "11";
        if (n == 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 3; i <= n; i++) {
            int curDigit = toDigit(s.charAt(0));
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                int nextDigit = toDigit(s.charAt(j));
                if (curDigit == nextDigit) {
                    count++;
                } else {
                    sb.append(count).append(curDigit);
                    curDigit = nextDigit;
                    count = 1;
                }
            }
            sb.append(count).append(curDigit);
            s = sb.toString();
            sb.setLength(0);
        }

        return s;
    }

    private int toDigit(char c) {
        return c - '0';
    }
}
