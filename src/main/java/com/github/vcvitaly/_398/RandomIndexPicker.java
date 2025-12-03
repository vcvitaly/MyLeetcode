package com.github.vcvitaly._398;

import java.util.*;

public class RandomIndexPicker {

    private final Map<Integer, List<Integer>> m;
    private final Random r;

    public RandomIndexPicker(int[] nums) {
        m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            final List<Integer> numIndexes = m.computeIfAbsent(num, key -> new ArrayList<>());
            numIndexes.add(i);
        }
        r = new Random();
    }

    public int pick(int target) {
        final List<Integer> numIndexes = m.get(target);
        return numIndexes.get(r.nextInt(numIndexes.size()));
    }
}
