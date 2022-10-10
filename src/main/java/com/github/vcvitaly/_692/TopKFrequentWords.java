package com.github.vcvitaly._692;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TopKFrequentWords.
 *
 * @author Vitalii Chura
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0) {
            return Collections.emptyList();
        }
        Map<String, Integer> countMap = toCountMap(words);
        Queue<WordWithCount> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (String word : countMap.keySet()) {
            pQ.add(new WordWithCount(word, countMap.get(word)));
        }
        List<String> topKFrequent = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topKFrequent.add(pQ.remove().word);
        }
        return topKFrequent;
    }

    private Map<String, Integer> toCountMap(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.merge(word, 1, Integer::sum);
        }
        return countMap;
    }

    private static class WordWithCount implements Comparable<WordWithCount> {
        private String word;
        private int count;

        public WordWithCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordWithCount o) {
            int countCompare = Integer.compare(count, o.count);
            return countCompare != 0 ? countCompare : -word.compareTo(o.word);
        }
    }
}
