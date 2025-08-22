package com.github.vcvitaly._55;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        Boolean[] dp = new Boolean[nums.length];
        return canJumpInternal(nums, dp, 0);
    }

    private boolean canJumpInternal(int[] nums, Boolean[] dp, int position) {
        if (dp[position] != null) {
            return dp[position];
        }
        if (willReachFromCurrent(nums, position)) {
            return true;
        }
        if (nums[position] == 0) {
            dp[position] = false;
            return false;
        }
        for (int i = position + 1; i <= position + nums[position]; i++) {
            if (canJumpInternal(nums, dp, i)) {
                return true;
            }
            dp[i] = false;
        }
        return false;
    }

    private boolean willReachFromCurrent(int[] nums, int position) {
        return position == nums.length - 1 || position + nums[position] > nums.length;
    }
}
