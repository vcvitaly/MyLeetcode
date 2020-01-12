package com.github.vcvitaly._20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesesChecker {

    public static final Map<Character, Character> PARENTHESES = new HashMap<>();

    static {
        PARENTHESES.put('(', ')');
        PARENTHESES.put('[', ']');
        PARENTHESES.put('{', '}');
    }

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpeningParentheses(c)) {
                characterStack.push(c);
            } else {
                if (characterStack.empty()) {
                    return false;
                }
                Character character = characterStack.pop();
                if (PARENTHESES.get(character) != c) {
                    return false;
                }
            }
        }

        return characterStack.empty();
    }

    private boolean isOpeningParentheses(char c) {
        if (PARENTHESES.containsKey(c)) {
            return true;
        } else if (PARENTHESES.containsValue(c)) {
            return false;
        } else {
            throw new IllegalArgumentException(c + " must be one of " + PARENTHESES);
        }
    }
}
