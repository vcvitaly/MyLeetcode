package com.github.vcvitaly._1268;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

public class SearchSuggestionSystem {

    private static final int MAX_ITEMS = 3;
    private static final Character START = '^';
    private static final Character END = '$';
    private static final Function<Node, Node> END_NODE_PRODUCER =
            parent -> new Node(parent, END, null);
    private final Node root = new Node(null, START);

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            insert(product);
        }
        final List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            results.add(
                    List.copyOf(
                            prefixes(searchWord.substring(0, 1 + i))
                    )
            );
        }
        return results;
    }

    private void insert(String word) {
        int i = 0;
        Node current = root;
        for (; i < word.length(); i++) {
            final Character c = word.charAt(i);
            if (current.hasKey(c)) {
                current = current.getChild(c);
            } else {
                break;
            }
        }
        for (; i < word.length(); i++) {
            final Character c = word.charAt(i);
            final Node newNode = new Node(current, c);
            current.addChild(c, newNode);
            current = newNode;
        }
        current.addChild(END, END_NODE_PRODUCER.apply(current));
    }

    private Set<String> prefixes(String word) {
        int i = 0;
        Node current = root;
        for (; i < word.length(); i++) {
            final Character c = word.charAt(i);
            if (current.hasKey(c)) {
                current = current.getChild(c);
            } else {
                return new LinkedHashSet<>();
            }
        }
        return dfs(current);
    }

    private Set<String> dfs(Node subTree) {
        final Set<String> set = new LinkedHashSet<>();
        final Stack<ChildrenContainer> stack = new Stack<>();
        stack.add(new ChildrenContainer(subTree.children()));
        while (!stack.isEmpty() && set.size() < MAX_ITEMS) {
            final ChildrenContainer current = stack.peek();
            if (current.hasNext()) {
                final Node childNode = current.next();
                if (childNode.isEndNode()) {
                    final String word = childNode.getWord();
                    set.add(word);
                } else {
                    stack.push(new ChildrenContainer(childNode.children()));
                }
            } else {
                stack.pop();
            }
        }
        return set;
    }

    private static class Node {
        private final Node parent;
        private final Character value;
        private final Node[] edges;
        private String word;

        public Node(Node parent, Character value) {
            this(parent, value, new Node[27]);
        }

        public Node(Node parent, Character value, Node[] edges) {
            this.parent = parent;
            this.value = value;
            this.edges = edges;
        }

        public boolean hasKey(Character key) {
            return getChild(key) != null;
        }

        public Node getChild(Character key) {
            return edges[getIndex(key)];
        }

        public void addChild(Character key, Node child) {
            edges[getIndex(key)] = child;
        }

        public List<Node> children() {
            final List<Node> children = new ArrayList<>();
            for (Node child : edges) {
                if (child != null) {
                    children.add(child);
                }
            }
            return children;
        }

        public boolean isEndNode() {
            return value == END;
        }

        public String getWord() {
            if (word == null) {
                if (isRoot()) {
                    return "";
                }
                if (isEndNode()) {
                    word = parent.getWord();
                    return word;
                }
                word = parent.getWord() + value;
                return word;
            }
            return word;
        }

        private int getIndex(Character ch) {
            if (ch == END) {
                return 0;
            }
            final int index = (int) ch - 97 + 1;
            if (index < 0 || index > 26) {
                throw new IllegalArgumentException(
                        "Index out of range [%d] for character [%s]".formatted(index, ch)
                );
            }
            return index;
        }

        private boolean isRoot() {
            return parent == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", edges=" + edges +
                    '}';
        }
    }

    private static class ChildrenContainer {
        private final List<Node> children;
        private int lastVisited = -1;

        private ChildrenContainer(List<Node> children) {
            this.children = children;
        }

        private boolean hasNext() {
            return lastVisited < children.size() - 1;
        }

        public Node next() {
            return children.get(++lastVisited);
        }
    }
}
