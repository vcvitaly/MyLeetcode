package com.github.vcvitaly._146;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private static final int NOT_FOUND = -1;
    private final Map<Integer, DoublyLinkedListNode> m = new HashMap<>();
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyLinkedListNode node = m.get(key);
        if (Objects.isNull(node)) {
            return NOT_FOUND;
        }
        moveToTail(node);
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
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        reassignTail(node);
        node.next = null;
    }

    private void reassignTail(DoublyLinkedListNode node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private static class DoublyLinkedListNode {
        int key;
        private int val;
        private DoublyLinkedListNode prev;
        private DoublyLinkedListNode next;

        public DoublyLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            DoublyLinkedListNode node = (DoublyLinkedListNode) o;
            return key == node.key && val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, val);
        }

        @Override
        public String toString() {
            return "DoublyLinkedListNode{key=%d, val=%d}".formatted(key, val);
        }
    }
}
