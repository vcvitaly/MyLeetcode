package com.github.vcvitaly._295;

import com.github.vcvitaly.common.ListNode;

public class MedianFinder {

    private ListNode list;
    private int listSize;
    private boolean modified;
    private double median;

    public void addNum(int num) {
        if (list == null) {
            list = new ListNode(num);
        } else {
            ListNode current = list;
            ListNode prev = null;
            while (current != null && current.val < num) {
                prev = current;
                current = current.next;
            }
            if (current == null) {
                prev.next = new ListNode(num);
            } else {
                if (prev == null) {
                    list = new ListNode(num, current);
                } else {
                    prev.next = new ListNode(num, current);
                }
            }
        }
        listSize++;
        modified = true;
    }

    public double findMedian() {
        if (!modified) {
            return median;
        }
        modified = false;
        ListNode current = list;
        double median;
        final int until = listSize % 2 == 1 ? listSize/2 : listSize/2-1;
        for (int i = 0; i < until; i++) {
            current = current.next;
        }
        if (listSize % 2 == 1) {
            median = current.val;
            return median;
        }
        median = (current.val + current.next.val) / 2.0;
        return median;
    }
}
