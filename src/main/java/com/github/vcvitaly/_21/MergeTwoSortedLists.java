package com.github.vcvitaly._21;

import com.github.vcvitaly.common.ListNode;

/**
 * MergeTwoSortedLists.
 *
 * @author Vitalii Chura
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode result = null;
        if (list1.val <= list2.val) {
            result = list1;
            list1 = list1.next;
        } else {
            result = list2;
            list2 = list2.next;
        }
        ListNode head = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result.next.next = null;
            result = result.next;
        }

        result.next = list1 == null ? list2 : list1;

        return head;
    }
}
