package com.github.vcvitaly.util;

import com.github.vcvitaly.common.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil.
 *
 * @author Vitalii Chura
 */
public final class ListUtil {

    private ListUtil() {
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
