package com.github.vcvitaly._19;

import com.github.vcvitaly.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * RemoveNthNodeFromEndOfList.
 *
 * @author Vitalii Chura
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }

        if (n == 1) {
            nodes.get(nodes.size()-2).next = null;
            return head;
        }
        if (n == nodes.size()) {
            return nodes.get(1);
        }

        nodes.get(nodes.size() - n - 1).next = nodes.get(nodes.size() - n).next;

        return head;
    }
}
