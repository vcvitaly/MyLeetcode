package com.github.vcvitaly._724;

/**
 * FindPivotIndex.
 *
 * @author Vitalii Chura
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0 ? 0 : -1;
        }

        int[] sums = sums(nums);
        for (int i = 0; i < sums.length; i++) {
            if (leftSum(nums, sums, i) == rightSum(nums, sums, i)) {
                return i;
            }
        }

        return -1;
    }

    private int[] sums(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }

    private int leftSum(int[] nums, int[] sums, int i) {
        return sums[i] - nums[i];
    }

    private int rightSum(int[] nums, int[] sums, int i) {
        return sums[sums.length - 1] - sums[i];
    }
}
