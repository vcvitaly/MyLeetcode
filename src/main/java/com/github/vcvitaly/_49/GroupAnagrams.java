package com.github.vcvitaly._49;

import java.util.List;

/**
 * GroupAnagrams.
 *
 * @author Vitalii Chura
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }

        return List.of(List.of());
    }
}
