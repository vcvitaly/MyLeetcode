package com.github.vcvitaly._234;

/**
 * PalindromeLinkedList.
 *
 * @author Vitalii Chura
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(head.val);
            head = head.next;
        }
        while (head != null);

        return sb.toString().equals(sb.reverse().toString());
    }
}
