package com.github.vcvitaly._6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigZagConverter {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        final List<StringBuilder> rows = IntStream.rangeClosed(1, numRows)
                .mapToObj(i -> new StringBuilder())
                .toList();

        boolean increasing = true;
        int rowNum = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            rows.get(rowNum).append(c);
            if (increasing) {
                rowNum++;
                if (rowNum == numRows - 1) {
                    increasing = false;
                }
            } else {
                rowNum--;
                if (rowNum == 0) {
                    increasing = true;
                }
            }
        }

        return rows.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.joining(""));
    }
}
