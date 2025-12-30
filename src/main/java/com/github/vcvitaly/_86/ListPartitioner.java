package com.github.vcvitaly._86;

import com.github.vcvitaly.common.ListNode;

// WIP
public class ListPartitioner {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode smallerPartitionTail = dummyHead;
        ListNode prev = null;
        ListNode biggerPartitionHead = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x && (prev == null || prev.val < x)) {
                smallerPartitionTail.next = cur;
                smallerPartitionTail = smallerPartitionTail.next;
                smallerPartitionTail.next = biggerPartitionHead;
                if (prev != null) {
                    prev.next = cur.next;
                }
            } else {
                if (biggerPartitionHead == null) {
                    biggerPartitionHead = cur;
                }
                prev = cur;
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
