package com.github.vcvitaly._295;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlowMedianFinder implements MedianFinder {

    private final List<Integer> list = new ArrayList<>();
    private boolean modified;

    @Override
    public void addNum(int num) {
        list.add(num);
        modified = true;
    }

    @Override
    public double findMedian() {
        if (modified) {
            list.sort(Comparator.naturalOrder());
            modified = false;
        }
        if (list.size() % 2 == 1) {
            return list.get(list.size() / 2);
        }
        return (list.get((list.size() / 2)) + list.get(list.size() / 2 - 1)) / 2.0;
    }
}
