package com.github.vcvitaly._53;

import java.util.ArrayList;
import java.util.List;

public class MaxSubarrayFinder {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }


        final List<Integer> merged = new ArrayList<>();

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

        while (i < merged.size()) {
            int cur = merged.get(i);
            if (cur + curSubArray > 0) {
                curSubArray = cur + curSubArray;
                if (curSubArray > maxSubArray) {
                    maxSubArray = curSubArray;
                }
            } else {
                curSubArray = 0;
            }
            i++;
        }

        return maxSubArray;
    }
}
