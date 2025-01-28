package com.github.vcvitaly._198;

public class HouseRobbingOptimizer {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Integer[] maxes = new Integer[nums.length + 2];
        return rob(nums, maxes, 0);
    }

    private int rob(int[] nums, Integer[] maxes, int from) {
        if (maxes[from] != null) {
            return maxes[from];
        }
        if (from >= nums.length) {
            maxes[from] = 0;
            return maxes[from];
        }
        if (from == nums.length - 1) {
            maxes[from] = nums[nums.length - 1];
            return maxes[from];
        }
        maxes[from] = Math.max(
                nums[from] + rob(nums, maxes, from + 2),
                rob(nums, maxes, from + 1)
        );
        return maxes[from];
    }
}
