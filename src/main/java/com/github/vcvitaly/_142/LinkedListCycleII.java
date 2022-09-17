package com.github.vcvitaly._142;

import com.github.vcvitaly.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * LinkedListCycleII.
 *
 * @author Vitalii Chura
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.hashCode())) {
                return head;
            }
            set.add(head.hashCode());
            head = head.next;
        }

        return null;
    }
}
