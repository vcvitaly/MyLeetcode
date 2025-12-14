package com.github.vcvitaly._53;

import java.util.LinkedList;
import java.util.List;

// WIP
public class MaxSubarrayFinder {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }


        final List<Integer> merged = new LinkedList<>();

        int max = nums[0];
        boolean mergedPositive = nums[0] >= 0;
        int mergedSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > max) {
                max = cur;
            }
            boolean curPositive = cur >= 0;
            if (mergedPositive == curPositive) {
                mergedSum += cur;
            } else {
                merged.add(mergedSum);
                mergedPositive = curPositive;
                mergedSum = cur;
            }
        }
        merged.add(mergedSum);

        if (merged.size() == 1) {
            if (merged.getFirst() >= 0) {
                return merged.getFirst();
            }
            return max;
        }
        if (merged.size() == 2) {
            return merged.stream().max(Integer::compareTo).get();
        }

        int maxSubArray = merged.getFirst() >= 0 ? merged.getFirst() : merged.get(1);
        int curSubArray = maxSubArray;
        int i = merged.getFirst() > 0 ? 1 : 2;
        boolean skipNegative = false;
        while (i < merged.size()) {
            if (merged.get(i) < 0) {
                if (Math.abs(merged.get(i)) < curSubArray && i + 1 < merged.size() && curSubArray + merged.get(i) + merged.get(i + 1) > curSubArray) {
                    curSubArray += merged.get(i) + merged.get(i + 1);
                } else {
                    skipNegative = true;
                }
            } else {
                if (skipNegative) {
                    curSubArray = merged.get(i);
                    skipNegative = false;
                } else if (merged.get(i) > curSubArray) {
                    curSubArray = merged.get(i);
                }
            }
            i++;
            if (curSubArray > maxSubArray) {
                maxSubArray = curSubArray;
            }
        }

        return maxSubArray;
    }
}
