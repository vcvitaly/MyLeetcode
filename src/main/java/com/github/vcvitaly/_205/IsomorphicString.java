package com.github.vcvitaly._205;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * IsomorphicString.
 *
 * @author Vitalii Chura
 */
public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() <= 1) {
            return true;
        }

        Map<Character, List<Integer>> sPositionMap = toLetterPositionMap(s);
        Map<Character, List<Integer>> tPositionMap = toLetterPositionMap(t);

        Iterator<List<Integer>> tValuesIterator = tPositionMap.values().iterator();
        for (List<Integer> sLetterPositions : sPositionMap.values()) {
            List<Integer> tLetterPositions = tValuesIterator.next();
            if (!sLetterPositions.equals(tLetterPositions)) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, List<Integer>> toLetterPositionMap(String s) {
        Map<Character, List<Integer>> positionMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            positionMap.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }
        return positionMap;
    }
}
