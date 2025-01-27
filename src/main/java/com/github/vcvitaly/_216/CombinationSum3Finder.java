package com.github.vcvitaly._216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3Finder {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinations(new SolutionSet(1, 9, k), n);
    }

    private List<List<Integer>> combinations(SolutionSet range, int target) {
        if (range.onlyOneNumberRemains() && range.to <= target) {
            return new ArrayList<>(List.of(List.of(range.to)));
        }
        final List<List<Integer>> with = new ArrayList<>();
        final List<List<Integer>> without = combinations(range.next(), target);
        for (List<Integer> combination : without) {
            if (combination.stream().mapToInt(Integer::intValue).sum() + range.from == target) {
                final List<Integer> copy = new ArrayList<>(combination);
                copy.add(range.from);
                with.add(copy);
            }
        }
        return with.size() > without.size() ? with : without;
    }

    private record SolutionSet(int from, int to, int numbersRemaining) {

        public boolean hasNext() {
            return length() > 0 && numbersRemaining > 0;
        }

        public boolean onlyOneNumberRemains() {
            return numbersRemaining == 1 && length() == 1;
        }

        public SolutionSet next() {
            return new SolutionSet(from + 1, to, numbersRemaining - 1);
        }

        private int length() {
            return to - from + 1;
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
