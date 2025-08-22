package com.github.vcvitaly._295;

import java.util.*;

public class MedianFinder {

    private final MedianList medians = new MedianList();
    private final Map<Integer, Integer> countMap = new HashMap<>();
    private final NavigableSet<NumberNode> tree = new TreeSet<>();

    public void addNum(int num) {
        if (countMap.isEmpty()) {
            int position = 0;
            countMap.put(num, position);
            NumberNode node = new NumberNode(num, position);
            tree.add(node);
            medians.add(node);
            return;
        }
        final int position = countMap.merge(num, 1, Integer::sum);
        final NumberNode node = new NumberNode(num, position);
        tree.add(node);
        if (medians.size() == 2) {
            if (node.gt(medians.getLast())) {
                medians.clearAndAdd(medians.getLast());
            } else if (node.lt(medians.getFirst())) {
                medians.clearAndAdd(medians.getFirst());
            } else {
                medians.clearAndAdd(node);
            }
        } else if (medians.size() == 1) {
            if (node.gt(medians.getFirst())) {
                medians.add(tree.higher(medians.getFirst()));
            } else {
                medians.add(tree.lower(medians.getFirst()));
            }
        } else {
            throw new IllegalStateException("Medians should not be empty here or contain more than 2 elements");
        }
    }

    public double findMedian() {
        return medians.median();
    }

    private record NumberNode(int num, int position) implements Comparable<NumberNode> {
        @Override
        public int compareTo(NumberNode o) {
            return Comparator.comparingInt(NumberNode::num).thenComparingInt(NumberNode::position).compare(this, o);
        }

        public boolean gt(NumberNode other) {
            return compareTo(other) > 0;
        }

        public boolean lt(NumberNode other) {
            return compareTo(other) < 0;
        }
    }

    private static class MedianList extends LinkedList<NumberNode> {
        @Override
        public boolean add(NumberNode node) {
            return super.add(node);
        }

        public void clearAndAdd(NumberNode node) {
            clear();
            add(node);
        }

        public double median() {
            sort(Comparator.naturalOrder());
            final double sum = stream()
                    .mapToInt(NumberNode::num)
                    .sum();
            return sum / size();
        }
    }
}
