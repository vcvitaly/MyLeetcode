package com.github.vcvitaly._206;

import com.github.vcvitaly.common.ListNode;

/**
 * ReverseLinkedList.
 *
 * @author Vitalii Chura
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = newHead;
            newHead = head;
            head = head.next;
            newHead.next = tmp;
        }

        return newHead;
    }
}
