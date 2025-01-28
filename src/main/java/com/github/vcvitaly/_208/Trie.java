package com.github.vcvitaly._208;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private static final Character START = '^';
    private static final Character END = '$';
    private static final Node END_NODE = new Node(END, null);
    private final Node root = new Node(START);

    public Trie() {}

    public void insert(String word) {
        int i = 0;
        Node current = root;
        for (; i < word.length(); i++) {
            final Character c = word.charAt(i);
            if (current.hasKey(c)) {
                current = current.getChild(c);
            } else {
                final Node newNode = new Node(c);
                current.addChild(c, newNode);
                current = newNode;
            }
        }
        current.addChild(END, END_NODE);
    }

    public boolean search(String word) {
        int i = 0;
        Node current = root;
        for (; i < word.length(); i++) {
            final Character c = word.charAt(i);
            if (current.hasKey(c)) {
                current = current.getChild(c);
            } else {
                return false;
            }
        }
        return current.hasKey(END);
    }

    public boolean startsWith(String prefix) {
        int i = 0;
        Node current = root;
        for (; i < prefix.length(); i++) {
            final Character c = prefix.charAt(i);
            if (current.hasKey(c)) {
                current = current.getChild(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static class Node {
        private Character value;
        private Map<Character, Node> edges;

        public Node(Character value) {
            this.value = value;
            edges = new HashMap<>();
        }

        public Node(Character value, Map<Character, Node> edges) {
            this.value = value;
            this.edges = edges;
        }

        public boolean hasKey(Character key) {
            return edges.containsKey(key);
        }

        public Node getChild(Character key) {
            return edges.get(key);
        }

        public void addChild(Character key, Node child) {
            edges.put(key, child);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", edges=" + edges +
                    '}';
        }
    }
}
