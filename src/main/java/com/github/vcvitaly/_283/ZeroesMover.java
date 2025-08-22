package com.github.vcvitaly._283;

public class ZeroesMover {

    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        final int[] zeroCounts = new int[nums.length];

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            zeroCounts[i] = zeroCount;
        }
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (num != 0) {
                final int shift = Math.min(i, zeroCounts[i]);
                final int newIndex = Math.max(i - shift, 0);
                nums[newIndex] = num;
            }
        }
        for (int i = nums.length - 1, j=0; j < zeroCount; i--, j++) {
            nums[i] = 0;
        }
    }
}
