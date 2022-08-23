package com.github.vcvitaly._82;

import com.github.vcvitaly.common.ListNode;

/**
 * RemoveDuplicatesFromSortedListII.
 *
 * @author Vitalii Chura
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        boolean insideSequence = false;
        ListNode prev = null;
        ListNode prevTmp = null;
        ListNode newHead = head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                insideSequence = true;
            } else {
                if (insideSequence) {
                    if (prev == null) {
                        newHead = cur.next;
                    } else {
                        prev.next = cur.next;
                    }
                    insideSequence = false;
                } else {
                    prev = cur;
                }
            }
            prevTmp = cur;
            cur = cur.next;
        }
        if (insideSequence && prev != null) {
            prev.next = null;
        }
        return prev == null && (head.val == newHead.val || prevTmp.val == cur.val) ? null : newHead;
    }
}
