package com.github.vcvitaly._53;

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

        int maxSubArray = prefixSums[prefixSums.length-1];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] >= nums[right]) {
                right--;
            } else {
                left++;
            }
            maxSubArray = Math.max(maxSubArray, prefixSums[right] - prefixSums[left] + nums[left]);
        }

        return maxSubArray;
    }
}
