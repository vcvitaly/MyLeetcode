package com.github.vcvitaly._216;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationSum3Finder {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinations(new SolutionSet(1, 9, k), n);
    }

    private List<List<Integer>> combinations(SolutionSet solutionSet, int target) {
        if (solutionSet.onlyOneNumberRemains()) {
            for (Integer i : solutionSet.iterate()) {
                if (i == target) {
                    return List.of(List.of(i));
                }
            }
            return List.of();
        }
        final List<List<Integer>> with = new ArrayList<>();
        final List<List<Integer>> without = combinations(solutionSet.next(), target);
        for (List<Integer> combination : without) {
            if (sum(combination) + solutionSet.from == target) {
                final List<Integer> copy = new ArrayList<>(combination);
                copy.add(solutionSet.from);
                with.add(copy);
            }
        }
        return with.size() > without.size() ? with : without;
    }

    private static int sum(List<Integer> combination) {
        return combination.stream().mapToInt(Integer::intValue).sum();
    }

    private record SolutionSet(int from, int to, int numbersRemaining) {

        public boolean hasNext() {
            return length() > 0 && numbersRemaining > 0;
        }

        public boolean onlyOneNumberRemains() {
            return numbersRemaining == 1 || length() == 1;
        }

        public SolutionSet next() {
            return new SolutionSet(from + 1, to, numbersRemaining - 1);
        }

        private int length() {
            return to - from + 1;
        }

        public List<Integer> iterate() {
            return IntStream.rangeClosed(from, to).boxed().toList();
        }

        @Override
        public String toString() {
            return "SolutionSet{" +
                    "from=" + from +
                    ", to=" + to +
                    ", numbersRemaining=" + numbersRemaining +
                    '}';
        }
    }
}
