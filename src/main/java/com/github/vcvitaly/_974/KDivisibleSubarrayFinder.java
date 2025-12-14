package com.github.vcvitaly._974;

// WIP
public class KDivisibleSubarrayFinder {

    public int subarraysDivByK(int[] nums, int k) {
        if (nums.length == 1) {
            return isDivisible(nums[0], k) ? 1 : 0;
        }

        return 0;
    }

    private boolean isDivisible(int i, int possibleDivisor) {
        return i % possibleDivisor == 0;
    }
}
