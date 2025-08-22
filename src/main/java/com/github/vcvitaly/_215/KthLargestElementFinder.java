package com.github.vcvitaly._215;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class KthLargestElementFinder {

    public int findKthLargest(int[] nums, int k) {
        final Map<Integer, Integer> countByElement = new LinkedHashMap<>();
        for (int num : nums) {
            countByElement.merge(num, 1, Integer::sum);
        }
        int passed = 0;
        final ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countByElement.entrySet());
        for (int i = entries.size() - 1; i >= 0; i--) {
            final Map.Entry<Integer, Integer> e = entries.get(i);
            if (passed + e.getValue() > k) {
                return e.getKey();
            }
            passed += e.getValue();
        }
        return -1;
    }
}
