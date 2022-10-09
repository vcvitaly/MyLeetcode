package com.github.vcvitaly._438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FindAllAnagramsInAString.
 *
 * @author Vitalii Chura
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> anagramIndices = new ArrayList<>();
        char[] sCharArray = s.toCharArray();
        Map<Character, Integer> pCountMap = toCountMap(p.toCharArray(), 0, p.length());
        Map<Character, Integer> sPartCountMap = toCountMap(sCharArray, 0, p.length());
        if (isAnagramMap(pCountMap, sPartCountMap)) {
            anagramIndices.add(0);
        }
        for (int i = 1; i < sCharArray.length - p.length() + 1; i++) {
            slideCountMap(sPartCountMap, sCharArray[i-1], sCharArray[i+p.length()-1]);
            if (isAnagramMap(pCountMap, sPartCountMap)) {
                anagramIndices.add(i);
            }
        }
        return anagramIndices;
    }

    private Map<Character, Integer> toCountMap(char[] chars, int startIndex, int endIndex) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = startIndex; i < endIndex; i++) {
            countMap.merge(chars[i], 1, Integer::sum);
        }
        return countMap;
    }

    private boolean isAnagramMap(Map<Character, Integer> countMap1, Map<Character, Integer> countMap2) {
        for (Character c : countMap1.keySet()) {
            if (!countMap2.containsKey(c) || !countMap1.get(c).equals(countMap2.get(c))) {
                return false;
            }
        }
        return true;
    }

    private void slideCountMap(Map<Character, Integer> countMap, char charToRemove, char charToAdd) {
        countMap.merge(charToRemove, 0, (oldValue, newValue) -> oldValue - 1);
        countMap.merge(charToAdd, 1, Integer::sum);
    }
}
