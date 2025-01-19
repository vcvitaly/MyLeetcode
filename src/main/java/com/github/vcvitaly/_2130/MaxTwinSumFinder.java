package com.github.vcvitaly._2130;

import com.github.vcvitaly.common.ListNode;

public class MaxTwinSumFinder {

    public int pairSum(ListNode head) {
        int size = 0;
        ListNode curNode = head;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }
        int[] arr = new int[size];
        curNode = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curNode.val;
            curNode = curNode.next;
        }
        int middle = size / 2;
        int maxTwinSum = 0;
        for (int i = 0, j = size - 1; i < middle && j >= middle; i++, j--) {
            final int sum = arr[i] + arr[j];
            if (sum > maxTwinSum) {
                maxTwinSum = sum;
            }
        }
        return maxTwinSum;
    }
}
