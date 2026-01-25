package com.github.vcvitaly._146;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private final Map<Integer, DoublyLinkedListNode> m = new HashMap<>();
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return m.get(key).val;
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
                    tail.next = node;
                } else {
                    m.remove(head.key);
                    m.put(key, node);
                    if (capacity == 1) {
                        head = node;
                        tail = node;
                    } else {

                    }
                }
            } else {
                node.val = value;
                if (m.size() == 1) {
                    return;
                }
            }
        }
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
