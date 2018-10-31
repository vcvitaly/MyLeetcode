package com.github.vcvitaly._2;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public int toNumber() {
        int num = 0;
        int pow = 0;
        ListNode nextNode = this;
        while (nextNode != null) {
            num += nextNode.val * Math.pow(10, pow);
            nextNode = nextNode.next;
            pow++;
        }
        return num;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}