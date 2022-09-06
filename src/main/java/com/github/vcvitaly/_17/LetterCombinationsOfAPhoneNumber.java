package com.github.vcvitaly._17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * LetterCombinationsOfAPhoneNumber.
 *
 * @author Vitalii Chura
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, List<Character>> DECODE_MAP = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<StringBuilder>();
        for (int i = 0; i < digits.length(); i++) {
            var chars = DECODE_MAP.get(digits.charAt(i));
            if (result.isEmpty()) {
                for (Character aChar : chars) {
                    var sb = new StringBuilder();
                    sb.append(aChar);
                    result.add(sb);
                }
            } else {
                int resultSize = result.size();
                for (int j = 0; j < resultSize; j++) {
                    var currentCombination = result.get(0);
                    for (Character aChar : chars) {
                        var newCombination = new StringBuilder(currentCombination);
                        newCombination.append(aChar);
                        result.add(newCombination);
                    }
                    result.remove(0);
                }
            }
        }
        return result.stream()
                .map(StringBuilder::toString)
                .toList();
    }
}
