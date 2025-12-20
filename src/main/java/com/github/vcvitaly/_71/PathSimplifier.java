package com.github.vcvitaly._71;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

public class PathSimplifier {

    private static final String SLASH = "/" ;
    private static final String CUR_DUR = "." ;
    private static final String PARENT_DUR = ".." ;

    public String simplifyPath(String path) {
        final List<String> parts = Arrays.stream(path.split(SLASH))
                .filter(Predicate.not(String::isEmpty))
                .toList();
        if (parts.isEmpty()) {
            return SLASH;
        }

        final Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals(CUR_DUR)) {
                // do nothing
            } else if (part.equals(PARENT_DUR)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return SLASH;
        }

        return SLASH + String.join(SLASH, stack);
    }
}
