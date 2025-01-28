package com.github.vcvitaly._1268;

import com.github.vcvitaly._208.Trie;
import java.util.List;

public class SearchSuggestionSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

    }

    public static class Node {
        private Character value;
        private Trie.Node[] edges;

        public Node(Character value) {
            this(value, new Trie.Node[26]);
        }

        public Node(Character value, Trie.Node[] edges) {
            this.value = value;
            this.edges = edges;
        }

        public boolean hasKey(Character key) {
            return getChild(key) != null;
        }

        public Trie.Node getChild(Character key) {
            return edges[getIndex(key)];
        }

        public void addChild(Character key, Trie.Node child) {
            edges[getIndex(key)] = child;
        }

        private int getIndex(Character ch) {
            final int index = (int) ch - 97;
            if (index < 0 || index > 25) {
                throw new IllegalArgumentException(
                        "Index out of range [%d] for character [%s]".formatted(index, ch)
                );
            }
            return index;
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
