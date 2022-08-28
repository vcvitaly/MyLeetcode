package com.github.vcvitaly._1859;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * SortingTheSentence.
 *
 * @author Vitalii Chura
 */
public class SortingTheSentence {

    public String sortSentence(String s) {
        String[] parts = s.split(" ");
        String[] sortedParts = new String[parts.length];
        for (String part : parts) {
            int position = toDigit(part.charAt(part.length()-1));
            sortedParts[position-1]=part.substring(0, part.length()-1);
        }

        return String.join(" ", sortedParts);
    }

    private int toDigit(char c) {
        return c - 48;
    }
}
