package com.github.vcvitaly._2390;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * RemovingStarsFromAString.
 *
 * @author Vitalii Chura
 */
public class RemovingStarsFromAString {

    public String removeStars(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                chars.pop();
            } else {
                chars.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character aChar : chars) {
            sb.append(aChar);
        }

        return sb.toString();
    }
}
