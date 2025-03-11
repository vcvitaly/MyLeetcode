package com.github.vcvitaly._139;

import com.github.vcvitaly.common.TrieNode;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WordBreakDeterminator {

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        trie.insert(s);
        while (true) {
            Optional<TrieNode> next = wordDict.stream()
                    .map(trie::advance)
                    .filter(Objects::nonNull)
                    .findFirst();
            if (next.isPresent()) {
                TrieNode node = next.get();
                if (node.hasKey(Trie.END)) {
                    return true;
                }
                trie = new Trie(node);
            } else {
                return false;
            }
        }
    }

    private record Trie(TrieNode root) {

        private static final Character START = '^';
        private static final Character END = '$';
        private static final TrieNode END_NODE = new TrieNode(END, null);

        public Trie() {
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
