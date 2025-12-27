package com.github.vcvitaly._303;

public class NumArray {

    private final int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                prefixSums[i] =  prefixSums[i-1] + nums[i];
            }
        }

    }

    public int sumRange(int left, int right) {
        if (prefixSums.length == 0) {
            return prefixSums[0];
        }
        return prefixSums[right] - sumBeforeRangeStart(left);
    }

    private int sumBeforeRangeStart(int left) {
        if (left == 0) {
            return 0;
        }
        return prefixSums[left - 1];
    }
}
