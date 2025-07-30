package com.github.vcvitaly._139;

import com.github.vcvitaly.common.TrieNode;

import java.util.List;

public class TrieWordBreakDeterminator implements WordBreakDeterminator {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        final Trie trie = new Trie();
        trie.insert(s);
        return wordBreak(trie, s, 0, wordDict);
    }

    private boolean wordBreak(Trie trie, String s, int curCharIndex, List<String> wordDict) {
        for (String word : wordDict) {
            final AdvanceResult r = advance(trie, word);
            if (r != null) {
                if (r instanceof FinalResult) {
                    return true;
                }
                if (r instanceof IntermediateResult(TrieNode node, int shift) &&
                        wordBreak(
                                new Trie(node),
                                s,
                                curCharIndex + shift,
                                wordDict
                        )) {
                    return true;
                }
            }
        }
        return false;
    }

    private AdvanceResult advance(Trie trie, String word) {
        final TrieNode candidateNode = trie.advance(word);
        if (candidateNode == null) {
            return null;
        }
        if (candidateNode.hasKey(Trie.END)) {
            return new FinalResult();
        }
        return new IntermediateResult(candidateNode, word.length());
    }

    private sealed interface AdvanceResult permits IntermediateResult,FinalResult {}

    private record IntermediateResult(TrieNode node, int shift) implements AdvanceResult {}

    private record FinalResult() implements AdvanceResult {}

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
