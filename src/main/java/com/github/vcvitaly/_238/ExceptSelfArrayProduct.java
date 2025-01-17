package com.github.vcvitaly._238;

public class ExceptSelfArrayProduct {

    public int[] productExceptSelf(int[] nums) {
        final int[] result = new int[nums.length];
        final int[] prefixes = new int[nums.length];
        prefixes[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixes[i] = prefixes[i - 1] * nums[i - 1];
        }
        final int[] suffixes = new int[nums.length];
        suffixes[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixes[i] = suffixes[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixes[i] * suffixes[i];
        }
        return result;
    }
}
