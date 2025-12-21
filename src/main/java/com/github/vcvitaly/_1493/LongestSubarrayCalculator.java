package com.github.vcvitaly._1493;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayCalculator {

    public int longestSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        final List<Subarray> subArrays = new ArrayList<>();
        Subarray subarray = new Subarray(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            final int cur = nums[i];
            if (subarray.bit == cur) {
                subarray.length++;
            } else {
                subArrays.add(subarray);
                subarray = new Subarray(cur);
            }
        }
        subArrays.add(subarray);

        if (subArrays.size() == 1) {
            final Subarray first = subArrays.getFirst();
            if (first.bit == 1) {
                return first.length - 1;
            }
            return 0;
        }

        return getLongestSubarrayOfOnesLength(subArrays);
    }

    private int getLongestSubarrayOfOnesLength(List<Subarray> subArrays) {
        int longestSubarrayOfOnesLength = subArrays.getFirst().bit == 1 ? subArrays.getFirst().length : 0;
        int prevSubArrLength = longestSubarrayOfOnesLength;

        boolean canSkip = false;
        for (final Subarray curSubArr : subArrays) {
            if (curSubArr.bit == 1) {
                if (canSkip && curSubArr.length + prevSubArrLength > longestSubarrayOfOnesLength) {
                    longestSubarrayOfOnesLength = curSubArr.length + prevSubArrLength;
                } else {
                    if (curSubArr.length > longestSubarrayOfOnesLength) {
                        longestSubarrayOfOnesLength = curSubArr.length;
                    }
                }
                prevSubArrLength = curSubArr.length;
                canSkip = false;
            } else {
                if (curSubArr.length == 1) {
                    canSkip = true;
                }
            }
        }
        return longestSubarrayOfOnesLength;
    }

    private static class Subarray {
        private int length = 1;
        private final int bit;

        public Subarray(int bit) {
            this.bit = bit;
        }

        @Override
        public String toString() {
            return "Subarray{length=%d, bit=%d}".formatted(length, bit);
        }
    }
}
