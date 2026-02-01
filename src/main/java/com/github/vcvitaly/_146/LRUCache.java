package com.github.vcvitaly._146;

import java.util.*;

public class LRUCache {

    private static final int NOT_FOUND = -1;
    final Map<Integer, DoublyLinkedListNode> m = new HashMap<>();
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyLinkedListNode node = m.get(key);
        if (Objects.isNull(node)) {
            return NOT_FOUND;
        }
        if (capacity != 1) {
            moveToTail(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        if (m.isEmpty()) {
            final DoublyLinkedListNode node = m.computeIfAbsent(key, k -> new DoublyLinkedListNode(key, value));
            head = node;
            tail = node;
        } else {
            DoublyLinkedListNode node = m.get(key);
            if (node == null) {
                node = new DoublyLinkedListNode(key, value);
                if (m.size() < capacity) {
                    m.put(key, node);
                    reassignTail(node);
                } else {
                    m.remove(head.key);
                    m.put(key, node);
                    if (capacity == 1) {
                        head = node;
                        tail = node;
                    } else {
                        head = head.next;
                        head.prev = null;
                        reassignTail(node);
                    }
                }
            } else {
                node.val = value;
                if (m.size() != 1) {
                    moveToTail(node);
                }
            }
        }
    }

    private void moveToTail(DoublyLinkedListNode node) {
        if (node.key != tail.key) {
            if (node.prev != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                head = node.next;
                head.prev = null;
            }
            reassignTail(node);
            node.next = null;
        }
    }

    private void reassignTail(DoublyLinkedListNode node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    static class DoublyLinkedListNode {
        int key;
        int val;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;

        public DoublyLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
