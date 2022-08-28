package com.github.vcvitaly._2042;

/**
 * CheckIfNumbersAreAscendingInASentence.
 *
 * @author Vitalii Chura
 */
public class CheckIfNumbersAreAscendingInASentence {

    public boolean areNumbersAscending(String s) {
        String[] parts = s.split(" ");
        int prev = -1;
        for (String part : parts) {
            if (isDigit(part.charAt(0))) {
                int number = Integer.parseInt(part);
                if (number <= prev) {
                    return false;
                }
                prev = number;
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        return (c >= 48 && c <= 57);
    }
}
