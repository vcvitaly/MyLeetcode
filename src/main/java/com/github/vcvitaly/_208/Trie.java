package com.github.vcvitaly._208;

import com.github.vcvitaly.common.TrieNode;

public class Trie {

    private static final Character START = '^';
    private static final Character END = '$';
    private static final TrieNode END_NODE = new TrieNode(END, null);
    private final TrieNode root = new TrieNode(START);

    public Trie() {}

    public void insert(String word) {
        int i = 0;
        TrieNode current = root;
        for (; i < word.length(); i++) {
            final Character c = word.charAt(i);
            if (current.hasKey(c)) {
                current = current.getChild(c);
            } else {
                final TrieNode newNode = new TrieNode(c);
                current.addChild(c, newNode);
                current = newNode;
            }
        }
        current.addChild(END, END_NODE);
    }

    public boolean search(String word) {
        int i = 0;
        TrieNode current = root;
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
        TrieNode current = root;
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

}
