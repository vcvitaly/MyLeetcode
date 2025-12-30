package com.github.vcvitaly.util;

import com.github.vcvitaly.common.ListNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil.
 *
 * @author Vitalii Chura
 */
@UtilityClass
public final class ListUtil {

    public static ListNode buildLinkedList(int[] arrayRepresentation) {
        final ListNode head = new ListNode(arrayRepresentation[0]);
        ListNode cur = head;
        for (int i = 1; i < arrayRepresentation.length; i++) {
            ListNode next = new ListNode(arrayRepresentation[i]);
            cur.next = next;
            cur = next;
        }
        return head;
    }

    public static List<Integer> getIntegers(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }
}
