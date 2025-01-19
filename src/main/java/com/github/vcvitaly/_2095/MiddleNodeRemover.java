package com.github.vcvitaly._2095;

import com.github.vcvitaly.common.ListNode;

public class MiddleNodeRemover {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode curNode = head;
        int size = 0;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }
        int middle = size / 2;
        ListNode prev = null;
        curNode = head;
        for (int i = 0; i < middle; i++) {
            prev = curNode;
            curNode = curNode.next;
        }
        prev.next = curNode.next;
        return head;
    }
}
