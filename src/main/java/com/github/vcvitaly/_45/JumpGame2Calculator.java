package com.github.vcvitaly._45;

// TODO faster solution
public class JumpGame2Calculator {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            return nums[0] >= 1 ? 1 : 0;
        }

        int[] jumpsLeft = new int[nums.length];

        jumpsLeft[nums.length - 1] = 0;
        for (int i = jumpsLeft.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                jumpsLeft[i] = Integer.MAX_VALUE;
                continue;
            }
            int currentJumpsMin = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(jumpsLeft.length - 1, i + nums[i]); j++) {
                if (jumpsLeft[j] < currentJumpsMin) {
                    currentJumpsMin = jumpsLeft[j];
                }
            }
            if (currentJumpsMin == Integer.MAX_VALUE && i + nums[i] < nums.length - 1) {
                jumpsLeft[i] = Integer.MAX_VALUE;
            } else {
                jumpsLeft[i] = currentJumpsMin + 1;
            }
        }

        return jumpsLeft[0];
    }
}
