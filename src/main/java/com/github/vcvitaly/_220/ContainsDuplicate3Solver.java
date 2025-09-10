package com.github.vcvitaly._220;

import java.util.*;

public class ContainsDuplicate3Solver {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        final TreeList treeList = new TreeList();
        for (int i = 1; i <= Math.min(indexDiff, nums.length - 1); i++) {
            treeList.add(nums[i]);
        }
        int i = 0;
        do {
            final int num = nums[i];
            final Integer floor = treeList.floor(num);
            final Integer ceiling = treeList.ceiling(num);
            if (floor != null && withingRange(num, floor, valueDiff) ||
                    ceiling != null && withingRange(num, ceiling, valueDiff)) {
                return true;
            }
            treeList.removeFirst();
            i++;
            if (indexDiff + i < nums.length) {
                treeList.add(nums[indexDiff + i]);
            }
        } while (i < (nums.length - indexDiff) || !treeList.isEmpty());
        return false;
    }

    private boolean withingRange(int num, int otherNum, int valueDiff) {
        return Math.abs(num - otherNum) <= valueDiff;
    }

    private record TreeList(SequencedMap<Integer, Integer> bag, NavigableSet<Integer> tree) {
        TreeList() {
            this(new LinkedHashMap<>(), new TreeSet<>());
        }

        public void add(Integer i) {
            bag.merge(i, 1, Integer::sum);
            tree.add(i);
        }

        public void removeFirst() {
            final Map.Entry<Integer, Integer> first = bag.firstEntry();
            if (first != null) {
                final Integer key = first.getKey();
                final Integer val = first.getValue();
                if (val == 1) {
                    bag.remove(key);
                    tree.remove(key);
                } else if (val > 1) {
                    bag.putFirst(key, val - 1);
                } else {
                    throw new IllegalStateException("Key should be >= 1 but was: " + key);
                }
            }
        }

        public Integer floor(int i) {
            return tree.floor(i);
        }

        public Integer ceiling(Integer i) {
            return tree.ceiling(i);
        }

        public boolean isEmpty() {
            return bag.isEmpty();
        }
    }
}
