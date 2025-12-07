package com.github.vcvitaly._91;

import java.util.HashMap;
import java.util.Map;

public class DecodeWayCounter {

    private final Map<String, Character> dict = generateMap();

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }



        return 0;
    }

    private int numDecodings(String s, int i, Map<Integer, Integer> ways) {
        if (i == s.length() - 1) {
            ways.put(i, s.charAt(i) == '0' ? 0 : 1);
            return ways.get(i);
        }
        String nextChar = s.substring(i, i + 1);
        String nextTwoChars = s.substring(i, i + 2);
        int withNext = dict.containsKey(nextChar) ? dict.get(nextChar) : 0;
        int withNextTwo = dict.containsKey(nextTwoChars) ? dict.get(nextTwoChars) : 0;

        return -1;
    }

    private Map<String, Character> generateMap() {
        final Map<String, Character> map = new HashMap<>();
        map.put("1", 'A');
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(i + 1), (char) ('A' + i));
        }
        return map;
    }
}
