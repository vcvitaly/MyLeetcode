package com.github.vcvitaly._268;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        long arraySum = 0;
        long fullSequenceSum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        for (int i = 0; i <= nums.length; i++) {
            fullSequenceSum += i;
        }
        int missingNumber = (int) (fullSequenceSum - arraySum);
        return missingNumber;
    }
}
