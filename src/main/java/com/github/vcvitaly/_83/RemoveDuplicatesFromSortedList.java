package com.github.vcvitaly._83;

import com.github.vcvitaly.common.ListNode;
import java.util.List;

/**
 * RemoveDuplicatesFromSortedList.
 *
 * @author Vitalii Chura
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode originalHead = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return originalHead;
    }
}
