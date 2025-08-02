package com.github.vcvitaly._139;

import com.github.vcvitaly.common.TrieNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrieWordBreakDeterminator implements WordBreakDeterminator {

    // I need 2 tries

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<Character> dictChars = wordDict.stream()
                .map(this::chars)
                .reduce(new HashSet<>(), (acc, set) -> {
                    acc.addAll(set);
                    return acc;
                });
        final Set<Character> sChars = chars(s);
        if (!dictChars.containsAll(sChars)) {
            return false;
        }
        final Trie trie = new Trie();
        trie.insert(s);
        ArrayList<String> wordDictSorted = new ArrayList<>(wordDict);
        wordDictSorted.sort((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return -1;
            }
            if (s2.length() > s1.length()) {
                return 1;
            }
            return s1.compareTo(s2);
        });
        return wordBreak(trie, s, 0, wordDictSorted);
    }

    private Set<Character> chars(String s) {
        final Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        return chars;
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
