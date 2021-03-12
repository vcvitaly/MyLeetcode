package com.github.vcvitaly._217;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
}

