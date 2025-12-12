package com.github.vcvitaly._34;

public class FIrstLastPositionFinder {

    private static final int[] NOT_FOUND = {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return NOT_FOUND;
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[] {0, 0};
        }

        return null;
    }
}
