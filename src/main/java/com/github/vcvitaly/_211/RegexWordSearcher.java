package com.github.vcvitaly._211;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegexWordSearcher {

    private final Trie trie = new Trie();

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.contains(word);
    }

    record Trie(TrieNode root) {

        private static final Character END = '$';
        private static final TrieNode END_NODE = new TrieNode(NodeKind.END, null);

        Trie() {
            this(new TrieNode());
        }

        public void insert(String word) {
            int i = 0;
            TrieNode current = root;
            for (; i < word.length(); i++) {
                final Character c = word.charAt(i);
                if (current.hasKey(c)) {
                    current = current.getChild(c);
                } else {
                    final TrieNode newNode = new TrieNode(NodeKind.TRIE_NODE);
                    current.addChild(c, newNode);
                    current = newNode;
                }
            }
            current.addChild(END, END_NODE);
        }

        public boolean contains(String word) {
            return contains(root, -1, word);
        }

        private boolean contains(TrieNode node, int ind, String word) {
            ind++;
            if (ind < word.length()) {
                final char key = word.charAt(ind);
                if (node.hasKey(key)) {
                    return contains(node.getChild(key), ind, word);
                } else if (key == '.') {
                    if (node.keySet().size() == 1 && node.hasKey(END)) {
                        return false;
                    }
                    for (Character c : node.keySet()) {
                        if (contains(node.getChild(c), ind, word)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
            return node.hasKey(END);
        }
    }

    private record TrieNode(NodeKind kind, Map<Character, TrieNode> edges) {

        public TrieNode() {
            this(NodeKind.START, new HashMap<>());
        }

        public TrieNode(NodeKind kind) {
            this(kind, new HashMap<>());
        }

        public boolean hasKey(Character key) {
            return edges.containsKey(key);
        }

        public TrieNode getChild(Character key) {
            return edges.get(key);
        }

        public void addChild(Character key, TrieNode child) {
            edges.put(key, child);
        }

        public Set<Character> keySet() {
            return edges.keySet();
        }

        @Override
        public String toString() {
            return "TrieNode{edges=%s}".formatted(edges.keySet());
        }
    }

    private enum NodeKind {
        START, END, TRIE_NODE
    }
}
