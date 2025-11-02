package com.github.vcvitaly._10;

public class RegExMatcher {

    public boolean isMatch(String s, String p) {
        int pAt = 0;
        Token token = nextToken(p, pAt);
        for (int i = 0; i < s.length(); i++) {
            final char curChar = s.charAt(i);
            if (!token.matches(curChar)) {
                return false;
            }
            if (!token.repeatable()) {
                token = nextToken(p, ++pAt);
            }
        }
        return true;
    }

    private Token nextToken(String p, int at) {
        if (at < p.length()) {
            final boolean repeatable = at + 1 < p.length() && p.charAt(at + 1) == '*';
            return new Token(p.charAt(at), repeatable);
        }
        return null;
    }

    private record Token(char c, boolean repeatable) {
        private boolean matches(char other) {
            return other == c || c == '.';
        }
    }
}
