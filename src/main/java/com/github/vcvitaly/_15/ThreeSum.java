package com.github.vcvitaly._15;

import java.util.*;

/**
 * ThreeSum.
 *
 * @author Vitalii Chura
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        // nums.length -1 to account for + 1 in the code
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int difference = -nums[i];
            Set<int[]> pairs = twoSum(nums, i + 1, difference);
            for (int[] pair : pairs) {
                List<Integer> triple = new ArrayList<>(List.of(nums[i], pair[0], pair[1]));
                triple.sort(Comparator.naturalOrder());
                result.add(triple);
            }
        }
        return new ArrayList<>(result);
    }

    private Set<int[]> twoSum(int[] nums, int startIndex, int target) {
        Set<int[]> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> pairFoundFor = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && pairFoundFor.contains(nums[i])) {
                continue;
            }
            int difference = target - nums[i];
            if (set.contains(difference)) {
                int[] pair = new int[2];
                pair[0] = difference;
                pair[1] = nums[i];
                pairs.add(pair);
                pairFoundFor.add(difference);
            }
            set.add(nums[i]);
        }
        return pairs;
    }
}
