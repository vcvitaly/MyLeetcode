package com.github.vcvitaly._1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> positionsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (positionsMap.containsKey(difference)) {
                indices[0] = positionsMap.get(difference);
                indices[1] = i;
                return indices;
            }
            positionsMap.put(nums[i], i);
        }
        return indices;
    }

    public int[] twoSumSlow(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }
}
