package com.github.vcvitaly._876;

import com.github.vcvitaly.common.ListNode;

/**
 * MiddleOfTheLinkedList.
 *
 * @author Vitalii Chura
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode originHead = head;

        while (head != null) {
            count++;
            head = head.next;
        }

        head = originHead;
        int midIndex = count / 2;
        int i = 0;
        while (i++ < midIndex) {
            head = head.next;
        }

        return head;
    }
}
