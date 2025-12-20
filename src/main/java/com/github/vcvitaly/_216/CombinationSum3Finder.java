package com.github.vcvitaly._216;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// WIP
public class CombinationSum3Finder {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinations(new SolutionSet(1, 9, k), 0, n);
    }

    private List<List<Integer>> combinations(SolutionSet solutionSet, int currentSum, int target) {
        if (solutionSet.onlyOneNumberRemains()) {
            for (Integer i : solutionSet.iterate()) {
                if (i == target) {
                    System.out.println("returning " + List.of(List.of(i)));
                    return List.of(List.of(i));
                } else if (i > target) {
                    System.out.println("returning " + List.of());
                    return List.of();
                }
            }
        }
        final List<List<Integer>> with = new ArrayList<>();
        final List<List<Integer>> withoutWithReducedK = combinations(
                solutionSet.nextWithReducedK(), currentSum + solutionSet.from, target - solutionSet.from
        );
        final List<List<Integer>> withoutWithSameK = combinations(solutionSet.nextWithSameK(), currentSum, target);
        for (List<Integer> combination : withoutWithReducedK) {
            if (sum(combination) + solutionSet.from == target) {
                final List<Integer> copy = new ArrayList<>(combination);
                copy.addFirst(solutionSet.from);
                with.add(copy);
            }
        }
        System.out.println("returning " + Stream.of(with, withoutWithSameK).flatMap(Collection::stream).toList());
        return Stream.of(with, withoutWithSameK).flatMap(Collection::stream).toList();
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

        public SolutionSet nextWithReducedK() {
            return nextWith(numbersRemaining - 1);
        }

        public SolutionSet nextWithSameK() {
            return nextWith(numbersRemaining);
        }

        private SolutionSet nextWith(int numbersRemaining) {
            return new SolutionSet(from + 1, to, numbersRemaining);
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
