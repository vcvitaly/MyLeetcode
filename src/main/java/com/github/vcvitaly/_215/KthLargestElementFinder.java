package com.github.vcvitaly._215;

import java.util.HashSet;
import java.util.Set;

public class KthLargestElementFinder {

    public int findKthLargest(int[] nums, int k) {
        int largest = Integer.MIN_VALUE;
        int prevLargest = Integer.MAX_VALUE;
        Set<Integer> alreadyCheckedIndecies = new HashSet<>();
        for (int i = 0; i < k; i++) {
            largest = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                final int cur = nums[j];
                if (cur >= largest && cur <= prevLargest && !alreadyCheckedIndecies.contains(j)) {
                    largest = cur;
                }
            }
            for (int j = 0; j < nums.length; j++) {
                final int cur = nums[j];
                if (cur == largest) {
                    alreadyCheckedIndecies.add(j);
                    if (alreadyCheckedIndecies.size() >= k) {
                        return largest;
                    }
                }
            }
            prevLargest = largest;
        }
        return largest;
    }
}
