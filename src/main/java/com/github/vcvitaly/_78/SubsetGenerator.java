package com.github.vcvitaly._78;

import java.util.List;
import java.util.stream.Stream;

public class SubsetGenerator {

    public List<List<Integer>> subsets(int[] nums) {
        return subsetsUntil(nums, nums.length - 1);
    }

    private List<List<Integer>> subsetsUntil(int[] nums, int tillIndexIncl) {
        if (tillIndexIncl == 0) {
            return List.of(List.of(), List.of(nums[tillIndexIncl]));
        }

        final List<List<Integer>> subsetsWithoutTillIndex = subsetsUntil(nums, tillIndexIncl - 1);

        return Stream.concat(
                subsetsWithoutTillIndex.stream(),
                subsetsWithoutTillIndex.stream()
                        .map(l -> Stream.concat(l.stream(), Stream.of(nums[tillIndexIncl])).toList())
        ).toList();
    }
}
