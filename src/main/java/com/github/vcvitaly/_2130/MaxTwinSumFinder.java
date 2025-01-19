package com.github.vcvitaly._2130;

import com.github.vcvitaly.common.ListNode;
import java.util.Stack;

public class MaxTwinSumFinder {

    public int pairSum(ListNode head) {
        ListNode curNode = head;
        int size = 0;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }
        int middle = size / 2;
        final Stack<Integer> stack = new Stack<>();
        curNode = head;
        int i = 0;
        for (; i < middle; i++) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }
        int maxTwinSum = 0;
        for (; i < size; i++) {
            final int sum = stack.pop() + curNode.val;
            if (sum > maxTwinSum) {
                maxTwinSum = sum;
            }
            curNode = curNode.next;
        }
        return maxTwinSum;
    }
}
