package com.github.vcvitaly._139;

import com.github.vcvitaly.common.TrieNode;

import java.util.List;

public class TrielessWordBreakDeterminator implements WordBreakDeterminator {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict);
    }

    private boolean wordBreak(String s, int curCharIndex, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.startsWith(word, curCharIndex)) {
                if (word.length() == s.length() - curCharIndex) {
                    return true;
                }
                if (wordBreak(
                        s, curCharIndex + word.length(), wordDict
                )) {
                    return true;
                }
            }
        }
        return false;
    }
}
