package com.github.vcvitaly._25;

import com.github.vcvitaly.common.ListNode;

public class KGroupNodeReverser {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        // prepend cur to curHead until the end of k group is reached
        ListNode cur = head.next;
        int currentK = k;
        ListNode curHead = head;
        ListNode prevTail = null;
        ListNode curTail = null;
        while (cur != null) {
            if (currentK > 0) {
                if (curTail == null) {
                    curTail = cur;
                }
                ListNode next = cur.next;
                cur.next = curHead;
                curHead = cur;
                cur = next;
                currentK--;
            } else {
                currentK = k;
                if (prevTail != null) {
                    prevTail.next = curHead;
                } else {
                    head = curHead;
                }
                prevTail = cur;
                cur = cur.next;
                curHead = cur;
            }
        }
        return head;
    }

    private boolean lookAheadIfLongEnoughSublist(ListNode node, int k) {
        if (node == null) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return k == 0;
    }
}
