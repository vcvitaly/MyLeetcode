package com.github.vcvitaly._15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * ThreeSum.
 *
 * @author Vitalii Chura
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        // nums.length -1 to account for + 1 in the code
        for (int i = 0; i < nums.length - 1; i++) {
            int difference = -nums[i];
            List<int[]> pairs = twoSum(nums, i + 1, difference);
            for (int[] pair : pairs) {
                List<Integer> triple = new ArrayList<>(List.of(nums[i], pair[0], pair[1]));
                triple.sort(Comparator.naturalOrder());
                result.add(triple);
            }
        }
        return new ArrayList<>(result);
    }

    private List<int[]> twoSum(int[] nums, int startIndex, int target) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            int difference = target - nums[i];
            if (set.contains(difference)) {
                int[] pair = new int[2];
                pair[0] = difference;
                pair[1] = nums[i];
                pairs.add(pair);
            }
            set.add(nums[i]);
        }
        return pairs;
    }
}
