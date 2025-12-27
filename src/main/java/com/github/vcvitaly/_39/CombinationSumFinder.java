package com.github.vcvitaly._39;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// WIP
public class CombinationSumFinder {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<Integer> candidatesList = Arrays.stream(candidates)
                .filter(i -> i <= target)
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        if (candidatesList.isEmpty()) {
            return List.of(List.of());
        }

        candidatesList.sort(Comparator.reverseOrder());

        return List.copyOf(combinationSum(candidatesList, 0, target));
    }

    private Set<List<Integer>> combinationSum(List<Integer> candidatesList, int from, int target) {
        final Set<List<Integer>> result = new HashSet<>();

        if (from == candidatesList.size() - 1) {
            if (candidatesList.getLast() == target) {
                return Set.of(List.of(target));
            }
            if (target % candidatesList.getLast() == 0) {
                return Set.of(
                        IntStream.rangeClosed(1, target / candidatesList.getLast()).mapToObj(i -> candidatesList.getLast()).toList()
                );
            }
            return Set.of(List.of());
        }

        for (int i = from; i < candidatesList.size(); i++) {
            int candidate = candidatesList.get(i);
            int times =  target / candidate;
            for (int j = 0; j < times; j++) {
                List<Integer> list = new ArrayList<>();
            }
        }
    }
}
