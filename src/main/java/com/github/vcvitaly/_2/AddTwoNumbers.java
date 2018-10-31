package com.github.vcvitaly._2;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNodeFromString = addTwoNumbers.getListNodeFromString("1999");
        while (listNodeFromString != null) {
            System.out.println(listNodeFromString + " ");
            listNodeFromString = listNodeFromString.next;
        }
        System.out.println();
        listNodeFromString = addTwoNumbers.getListNodeFromString("1999");
        System.out.println(listNodeFromString.toNumber());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode firstNode = null;
        ListNode prevNode = null;
        ListNode currentNode = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            currentNode = new ListNode(sum);
            if (prevNode != null) {
                prevNode.next = currentNode;

            } else {
                firstNode = currentNode;
            }
            prevNode = currentNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode nodeWithDigitsRemaining = null;
        if (l1 != null) {
            nodeWithDigitsRemaining = l1;
        } else if (l2 != null) {
            nodeWithDigitsRemaining = l2;
        }
        while (nodeWithDigitsRemaining != null) {
            int sum = nodeWithDigitsRemaining.val + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            currentNode = new ListNode(sum);
            prevNode.next = currentNode;
            prevNode = currentNode;
            nodeWithDigitsRemaining = nodeWithDigitsRemaining.next;
        }
        if (carry > 0) {
            ListNode carryNode = new ListNode(carry);
            prevNode.next = carryNode;
            carry = 0;
        }
        return firstNode;
    }

    public ListNode getListNodeFromString(String number) {
        String[] digits = number.split("");
        ListNode firstNode = null;
        ListNode prevNode = null;
        for (int i = digits.length-1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.valueOf(digits[i]));
            if (prevNode != null) {
                prevNode.next = node;
            } else {
                firstNode = node;
            }
            prevNode = node;
        }
        return firstNode;
    }
}
