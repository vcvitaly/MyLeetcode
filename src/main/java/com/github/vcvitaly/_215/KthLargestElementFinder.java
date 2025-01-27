package com.github.vcvitaly._215;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KthLargestElementFinder {

    public int findKthLargest(int[] nums, int k) {
        int largest = Integer.MIN_VALUE;
        int prevLargest = Integer.MAX_VALUE;
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            largest = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                final int cur = nums[j];
                if (cur > largest && cur <= prevLargest &&
                        !map.getOrDefault(cur, Set.of()).contains(j)) {
                    largest = cur;
                    map.computeIfAbsent(cur, key -> new HashSet<>()).add(j);
                }
            }
            prevLargest = largest;
        }
        return largest;
    }
}
