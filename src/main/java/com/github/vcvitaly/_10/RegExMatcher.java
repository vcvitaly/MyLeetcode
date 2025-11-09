package com.github.vcvitaly._10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RegExMatcher {

    public boolean isMatch(String s, String p) {
        final List<Token> tokens = getTokens(p);
        int nonWildCardTokenCount = (int) tokens.stream().filter(Predicate.not(Token::wildcard)).count();
        if (nonWildCardTokenCount > s.length()) {
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length()) {
            final char curChar = s.charAt(sIndex);
            final Token token = tokens.get(tIndex);
            if (token.wildcard() && sIndex + nonWildCardTokenCount >= s.length()) {
                tIndex++;
                continue;
            }
            if (!token.matches(curChar)) {
                if (token.wildcard()) {
                    tIndex++;
                    if (tIndex >= tokens.size()) {
                        return false;
                    }
                    continue;
                }
                return false;
            }
            if (!token.wildcard()) {
                nonWildCardTokenCount--;
            }
            sIndex++;
            if (!token.wildcard() || sIndex + nonWildCardTokenCount >= s.length()) {
                tIndex++;
                if (tIndex >= tokens.size()) {
                    return sIndex >= s.length();
                }
            }
        }
        return nonWildCardTokenCount <= 0;
    }

    private List<Token> getTokens(String p) {
        final List<Token> tokens = new ArrayList<>();
        Token token = nextToken(p, 0);
        if (token == null) {
            return List.of();
        }
        tokens.add(token);
        while ((token = nextToken(p, token.endsAt() + 1)) != null) {
            tokens.add(token);
        }
        return tokens;
    }

    private Token nextToken(String p, int at) {
        if (at < p.length()) {
            final boolean repeatable = at + 1 < p.length() && p.charAt(at + 1) == '*';
            return new Token(p.charAt(at), repeatable, at + (repeatable ? 1 : 0));
        }
        return null;
    }

    public record Token(char c, boolean wildcard, int endsAt) {
        private boolean matches(char other) {
            return other == c || c == '.';
        }

        @Override
        public String toString() {
            return wildcard ? c + "*" : String.valueOf(c);
        }
    }
}
