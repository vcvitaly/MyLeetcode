package com.github.vcvitaly._1598;

import java.util.Stack;

/**
 * CrawlerLogFolder.
 *
 * @author Vitalii Chura
 */
public class CrawlerLogFolder {

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String log : logs) {
            if (isAlphaNumeric(log.charAt(0))) {
                stack.push(log);
            } else if (log.equals("../") && !stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack.size();
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
