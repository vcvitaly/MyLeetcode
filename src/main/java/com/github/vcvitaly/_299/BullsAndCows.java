package com.github.vcvitaly._299;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * BullsAndCows.
 *
 * @author Vitalii Chura
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
            return null;
        }
        int bulls = 0;
        int cows = 0;
        Map<Character, Set<Integer>> secretPositionMap = toPositionMap(secret);
        Map<Character, Set<Integer>> guessPositionMap = toPositionMap(guess);
        for (Character c : secretPositionMap.keySet()) {
            Set<Integer> secretPositions = secretPositionMap.get(c);
            Set<Integer> guessPositions = guessPositionMap.get(c);
            if (guessPositions == null) {
                continue;
            }
            int thisDigitBulls = 0;
            for (Integer secretPosition : secretPositions) {
                if (guessPositions.contains(secretPosition)) {
                    thisDigitBulls++;
                }
            }
            bulls += thisDigitBulls;
            cows += Math.min(secretPositions.size(), guessPositions.size()) - thisDigitBulls;
        }

        return String.format("%dA%dB", bulls, cows);
    }

    private Map<Character, Set<Integer>> toPositionMap(String s) {
        Map<Character, Set<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            positionMap.computeIfAbsent(s.charAt(i), key -> new HashSet<>()).add(i);
        }
        return positionMap;
    }
}
