package com.github.vcvitaly._39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

// WIP
public class CombinationSumFinder {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1) {
            if (candidates[0] == target) {
                return List.of(List.of(target));
            }
            if (target % candidates[0] == 0) {
                return List.of(
                        IntStream.rangeClosed(1, target / candidates[0]).mapToObj(i -> candidates[0]).toList()
                );
            }
            return List.of(List.of());
        }

        if (candidates[0] > target) {
            return List.of(List.of());
        }

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();

        }

        return List.copyOf(result);
    }
}
