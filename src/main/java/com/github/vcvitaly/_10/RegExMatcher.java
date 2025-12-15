package com.github.vcvitaly._10;

import java.util.*;
import java.util.function.Predicate;

// WIP
public class RegExMatcher {

    private static final Token DOT_WILDCARD = new Token('.', true);

    public boolean isMatch(String s, String p) {
        final List<Token> tokens = getMergedTokens(p);
        final Map<Integer, Integer> nonWildcardTokensRemaningAtPos = new HashMap<>();
        nonWildcardTokensRemaningAtPos.put(tokens.size() - 1, tokens.getLast().wildcard() ? 0 : 1);
        for (int i = tokens.size() - 2; i >= 0; i--) {
            nonWildcardTokensRemaningAtPos.put(
                    i, tokens.get(i).wildcard() ?
                            nonWildcardTokensRemaningAtPos.get(i + 1) :
                            nonWildcardTokensRemaningAtPos.get(i + 1) + 1
            );
        }
        return isMatch(s, 0, tokens, 0, nonWildcardTokensRemaningAtPos);
    }

    private boolean isMatch(String s, int sIndex, List<Token> tokens, int tIndex, Map<Integer, Integer> nonWildcardTokensRemaningAtPos) {
        int nonWildCardTokenCount = nonWildcardTokensRemaningAtPos.get(tIndex);
        if (nonWildCardTokenCount > s.length()) {
            return false;
        }
        while (sIndex < s.length()) {
            final char curChar = s.charAt(sIndex);
            final Token token = tokens.get(tIndex);
            if (token.wildcard() && sIndex + nonWildCardTokenCount >= s.length()) {
                tIndex++;
            } else {
                if (tIndex + 1 < tokens.size() && isMatch(s, sIndex, tokens, tIndex + 1, nonWildcardTokensRemaningAtPos)) {
                    return true;
                }
                if (!token.matches(curChar)) {
                    if (token.wildcard()) {
                        tIndex++;
                        if (tIndex >= tokens.size()) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
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
            }
        }
        return nonWildCardTokenCount <= 0;
    }

    private List<Token> getMergedTokens(String p) {
        final List<Token> tokens = getTokens(p);
        final List<Token> mergedTokens = new ArrayList<>();
        final SequencedSet<Token> window = new LinkedHashSet<>();
        for (final Token token : tokens) {
            if (token.wildcard()) {
                window.add(token);
            } else {
                mergedTokens.addAll(compressTokenWindow(window));
                window.clear();
                mergedTokens.add(token);
            }
        }

        if (!window.isEmpty()) {
            mergedTokens.addAll(compressTokenWindow(window));
        }

        return mergedTokens;
    }

    private SequencedSet<Token> compressTokenWindow(SequencedSet<Token> window) {
        if (window.contains(DOT_WILDCARD)) {
            return new LinkedHashSet<>(Set.of(DOT_WILDCARD));
        } else {
            return window;
        }
    }

    private List<Token> getTokens(String p) {
        final List<Token> tokens = new ArrayList<>();
        int i = 0;
        Token token;
        while ((token = nextToken(p, i)) != null) {
            tokens.add(token);
            i += token.wildcard() ? 2 : 1;
        }
        return tokens.isEmpty() ? List.of() : tokens;
    }

    private Token nextToken(String p, int at) {
        if (at < p.length()) {
            final boolean repeatable = at + 1 < p.length() && p.charAt(at + 1) == '*';
            return new Token(p.charAt(at), repeatable);
        }
        return null;
    }

    public record Token(char c, boolean wildcard) {
        private boolean matches(char other) {
            return other == c || matchesAny();
        }

        private boolean matchesAny() {
            return c == '.';
        }

        @Override
        public String toString() {
            return wildcard ? c + "*" : String.valueOf(c);
        }
    }
}
