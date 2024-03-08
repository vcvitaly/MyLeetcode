package com.github.vcvitaly._328;

import com.github.vcvitaly.common.ListNode;

/**
 * OddEvenLinkedList.
 *
 * @author Vitalii Chura
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        var origHead = head;

        var i = 0;
        var nextOddNodeIndex = 2;
        var nodeToBeUpdated = head;
        while (head != null) {
            if (i == nextOddNodeIndex) {
                var tmpNode = nodeToBeUpdated.next;
                nodeToBeUpdated.next = head;
                tmpNode.next = head.next;
                head.next = tmpNode;
                nodeToBeUpdated = head;
                head = tmpNode.next;
                nextOddNodeIndex += 2;
            } else {
                head = head.next;
            }
            i++;
        }

        return null;
    }
}
