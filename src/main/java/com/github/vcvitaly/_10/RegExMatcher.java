package com.github.vcvitaly._10;

public class RegExMatcher {

    public boolean isMatch(String s, String p) {
        Token token = nextToken(p, 0);
        if (token == null) {
            return false;
        }
        int i = 0;
        while (i < s.length()) {
            final char curChar = s.charAt(i);
            if (!token.matches(curChar)) {
                if (token.repeatable()) {
                    token = nextToken(p, token.endsAt() + 1);
                    if (token == null) {
                        return false;
                    }
                    continue;
                }
                return false;
            }
            if (!token.repeatable()) {
                token = nextToken(p, token.endsAt() + 1);
                if (token == null) {
                    return i + 1 == s.length();
                }
            }
            i++;
        }
        return token.repeatable() && token.endsAt() == p.length() - 1;
    }

    private String reducePattern(String p) {
        final StringBuilder sb = new StringBuilder();
        Token token = nextToken(p, 0);
        int i = 0;
        char compared = '-';
        while (i < p.length()) {
            final char curChar = p.charAt(i);
            if (token.repeatable()) {
                // TODO WIP
            } else {
                sb.append(curChar);
            }
        }
        return sb.toString();
    }

    private Token nextToken(String p, int at) {
        if (at < p.length()) {
            final boolean repeatable = at + 1 < p.length() && p.charAt(at + 1) == '*';
            return new Token(p.charAt(at), repeatable, at + (repeatable ? 1 : 0));
        }
        return null;
    }

    private record Token(char c, boolean repeatable, int endsAt) {
        private boolean matches(char other) {
            return other == c || c == '.';
        }

        @Override
        public String toString() {
            return repeatable ? c + "*" : String.valueOf(c);
        }
    }
}
