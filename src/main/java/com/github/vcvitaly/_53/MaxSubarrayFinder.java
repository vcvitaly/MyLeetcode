package com.github.vcvitaly._53;

// WIP
public class MaxSubarrayFinder {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        final int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }

        int maxSubArray = Integer.MIN_VALUE;

        int maxPrefixSumIndex = -1;
        for (int i = 0; i < prefixSums.length; i++) {
            if (prefixSums[i] > maxSubArray) {
                maxSubArray = prefixSums[i];
                maxPrefixSumIndex = i;
            }
        }

        for (int i = 0; i < maxPrefixSumIndex; i++) {
            int withoutPrefix = prefixSums[maxPrefixSumIndex] - prefixSums[i];
            if (withoutPrefix > maxSubArray) {
                maxSubArray = withoutPrefix;
            }
        }

        return maxSubArray;
    }
}
