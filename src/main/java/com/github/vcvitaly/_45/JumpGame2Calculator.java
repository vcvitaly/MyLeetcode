package com.github.vcvitaly._45;

public class JumpGame2Calculator {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            return nums[0] >= 1 ? 1 : 0;
        }

        int[] distanceLeft = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            distanceLeft[i] = Math.max(nums.length - i - nums[i], 0);
        }

        int jumps = 0;

        int i = 0;
        while (i < distanceLeft.length - 1) {
            int j = i;
            int minLeft = distanceLeft[j];
            int minIndexLeft = j;
            int boundary = Math.min(i + nums[i], distanceLeft.length - 1);
            while (j < boundary) {
                j++;
                if (distanceLeft[j] + j - i < minLeft) {
                    minLeft = distanceLeft[j];
                    minIndexLeft = j;
                }
            }
            i = minIndexLeft > i ? minIndexLeft : i + nums[i];
            jumps++;
        }

        return jumps;
    }
}
