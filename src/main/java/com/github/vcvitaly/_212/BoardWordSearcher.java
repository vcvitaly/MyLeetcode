package com.github.vcvitaly._212;

import com.github.vcvitaly.common.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// WIP
public class BoardWordSearcher {

    // Build a trie from words
    // Use trie iterator
    // Write a method to check cell neighbors

    public List<String> findWords(char[][] board, String[] words) {
        final Map<Character, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                indexes.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(i);
            }
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        final Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return List.of();
    }

    private void resetVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for  (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    record Trie(TrieNode root) {

        private static final Character START = '^';
        private static final Character END = '$';
        private static final TrieNode END_NODE = new TrieNode(END, null);

        Trie() {
            this(new TrieNode(START));
        }

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

        public TrieNode advance(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.hasKey(c)) {
                    current = current.getChild(c);
                } else {
                    return null;
                }
            }
            return current;
        }
    }
}
