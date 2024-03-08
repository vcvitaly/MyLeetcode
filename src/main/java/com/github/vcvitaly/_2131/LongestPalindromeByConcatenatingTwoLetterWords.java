package com.github.vcvitaly._2131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.groupingBy;

/**
 * LongestPalindromeByConcatenatingTwoLetterWords.
 *
 * @author Vitalii Chura
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return consistsOfTwoSameChars(words[0]) ? 2 : 0;
        }

        int longestPalindromeLength  = 0;
        Map<String, Integer> palindromicWordsCountMap = new HashMap<>();
        List<String> nonPalindromicWords = new ArrayList<>();
        for (String word : words) {
            if (consistsOfTwoSameChars(word)) {
                palindromicWordsCountMap.merge(word, 1, Integer::sum);
            } else {
                nonPalindromicWords.add(word);
            }
        }

        while (!nonPalindromicWords.isEmpty()) {
            var firstWord = nonPalindromicWords.remove(0);
            int i = 0;
            while (i < nonPalindromicWords.size()) {
                if (arePalindromicWords(firstWord, nonPalindromicWords.get(i))) {
                    nonPalindromicWords.remove(i);
                    longestPalindromeLength += 4;
                    break;
                }
                i++;
            }
        }

        var maxEntryOptional = palindromicWordsCountMap.entrySet().stream().max(Map.Entry.comparingByValue());
        if (maxEntryOptional.isEmpty()) {
            return longestPalindromeLength;
        }

        var mostRepeatedSameLetterWord = maxEntryOptional.get().getKey();
        var countOfMostRepeatedWord = palindromicWordsCountMap.remove(mostRepeatedSameLetterWord);
        longestPalindromeLength += countOfMostRepeatedWord * 2;

        boolean hasLeftOver = false;
        for (Integer i : palindromicWordsCountMap.values()) {
            if (i % 2 == 0) {
                longestPalindromeLength += i * 2;
            } else {
                hasLeftOver = true;
                longestPalindromeLength += (i - 1) * 2;
            }
        }
        if (hasLeftOver) {
            longestPalindromeLength += 2;
        }

        return longestPalindromeLength;
    }

    private boolean consistsOfTwoSameChars(String word) {
        return word.charAt(0) == word.charAt(1);
    }

    private boolean arePalindromicWords(String w1, String w2) {
        return w1.charAt(0) == w2.charAt(1) && w1.charAt(1) == w2.charAt(0);
    }
}
