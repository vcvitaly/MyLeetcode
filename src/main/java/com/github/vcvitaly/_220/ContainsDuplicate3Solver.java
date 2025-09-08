package com.github.vcvitaly._220;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ContainsDuplicate3Solver {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        final NavigableSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= indexDiff; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < (nums.length - indexDiff); i++) {
            final int num = nums[i];
            final Integer floor = set.floor(num);
            final Integer ceiling = set.ceiling(num);
            if (floor != null && withingRange(num, floor, valueDiff) ||
                    ceiling != null && withingRange(num, ceiling, valueDiff)) {
                return true;
            }
            set.removeFirst();
            set.add(nums[indexDiff + i + 1]);
        }
        return false;
    }

    private boolean withingRange(int num, int otherNum, int valueDiff) {
        return Math.abs(num - otherNum) <= valueDiff;
    }
}
