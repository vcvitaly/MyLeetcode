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

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return new int[] {
                        leftmostPosition(nums, target, mid),
                        rightmostPosition(nums, target, mid),
                };
            } else if (num < target) {

            } else if (num > target) {

            }
        }

        return NOT_FOUND;
    }

    private int leftmostPosition(int[] nums, int target, int firstKnownIndex) {
        return -1;
    }

    private int rightmostPosition(int[] nums, int target, int firstKnownIndex) {
        return -1;
    }
}
