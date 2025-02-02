package com.github.vcvitaly._1493;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayCalculator {

    public int longestSubarray(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int longestSubarrayOfOnesLength = 0;

        boolean hasEncounteredAtLeastOneZero = false;

        final List<Subarray> subArrays = new ArrayList<>();

        Subarray subarray = new Subarray(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            final int cur = nums[i];
            if (cur == 0) {
                hasEncounteredAtLeastOneZero = true;
            }
            if (subarray.digit == cur) {
                subarray.length++;
            } else {
                subArrays.add(subarray);
                subarray = new Subarray(cur);
            }
        }


        int previousWindowLength = 0;
        int currentWindowLength = 0;
//        int previousWindowFirstSubarrayLength = 0;
        boolean containsZero = false;
        for (Subarray subArray : subArrays) {
            if (subArray.digit == 1) {
                currentWindowLength += subArray.length;
            } else {
                if (subArray.length == 1 && !containsZero) {
                    containsZero = true;
                }

            }
        }

        if (!hasEncounteredAtLeastOneZero && longestSubarrayOfOnesLength > 0) {
            longestSubarrayOfOnesLength--;
        }

        return longestSubarrayOfOnesLength;
    }

    private static class Subarray {
        private int length = 1;
        private final int digit;

        public Subarray(int digit) {
            this.digit = digit;
        }
    }
}
