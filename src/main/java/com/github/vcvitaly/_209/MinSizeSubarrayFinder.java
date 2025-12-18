package com.github.vcvitaly._209;

public class MinSizeSubarrayFinder {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }
        if (nums[0] >= target) {
            return 1;
        }

        int left = 0;
        int right = 1;
        int minSize = Integer.MAX_VALUE;
        int cur = nums[0];
        int curSize = 1;
        while (right < nums.length) {
            if (nums[right] >= target) {
                return 1;
            }
            cur += nums[right];
            curSize++;
            if (cur >= target) {
                if (curSize < minSize) {
                    minSize = curSize;
                }
                while (cur > target && left < right) {
                    cur -= nums[left];
                    left++;
                    curSize--;
                    if (cur >= target && curSize < minSize) {
                        minSize = curSize;
                    }
                }
            }
            right++;
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
