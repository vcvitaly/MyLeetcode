package com.github.vcvitaly._39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TODO faster solution
public class CombinationSumFinder {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<Integer> candidatesList = Arrays.stream(candidates)
                .filter(i -> i <= target)
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        if (candidatesList.isEmpty()) {
            return List.of();
        }

        candidatesList.sort(Comparator.naturalOrder());

        List<List<Integer>> result = combinationSum(candidatesList, 0, target);
        return result.isEmpty() || result.getFirst().isEmpty() ? List.of() : result;
    }

    private List<List<Integer>> combinationSum(List<Integer> candidatesList, int from, int target) {
        if (from == candidatesList.size()) {
            return List.of(List.of());
        }

        if (from == candidatesList.size() - 1) {
            if (candidatesList.getLast() == target) {
                return List.of(List.of(target));
            }
            if (target % candidatesList.getLast() == 0) {
                return List.of(
                        IntStream.rangeClosed(1, target / candidatesList.getLast()).mapToObj(i -> candidatesList.getLast()).toList()
                );
            }
            return List.of(List.of());
        }

        final List<List<Integer>> result = new ArrayList<>();

        for (int i = from; i < candidatesList.size(); i++) {
            int candidate = candidatesList.get(i);
            if (candidate > target) {
                break;
            }
            List<List<Integer>> candidateCombinations = new ArrayList<>();
            int times =  target / candidate;
            for (int j = 1; j <= times; j++) {
                List<Integer> head = new ArrayList<>();
                for (int k = 1; k <= j; k++) {
                    head.add(candidate);
                }
                int remainder = target - candidate * j;
                if (remainder == 0) {
                    candidateCombinations.add(head);
                } else {
                    List<List<Integer>> tails = combinationSum(candidatesList, i + 1, remainder);
                    if (!tails.isEmpty()) {
                        List<List<Integer>> candidateTimesCombinations = tails.stream()
                                .filter(Predicate.not(List::isEmpty))
                                .map(tail -> {
                                    List<Integer> combination = new ArrayList<>(head);
                                    combination.addAll(tail);
                                    return combination;
                                }).toList();
                        candidateCombinations.addAll(candidateTimesCombinations);
                    }
                }
            }
            result.addAll(candidateCombinations);
        }

        return result;
    }
}
