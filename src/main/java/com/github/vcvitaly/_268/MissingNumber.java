package com.github.vcvitaly._268;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        long l = 0;
        for (int num : nums) {
            l += num;
        }
        int missingNumber = 0;
        boolean foundZeroSequence = false;
        for (int i = 0; i < 32; i++) {
            long bit = (l >> i) & 1;
            if (bit == 0) {
                foundZeroSequence = true;
                missingNumber += 1 << i;
            } else {
                if (foundZeroSequence) {
                    break;
                }
            }
        }
        return missingNumber;
    }
}
