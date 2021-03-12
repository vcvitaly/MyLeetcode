package com.github.vcvitaly._136;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toSet());
        for (int num : nums) {

        }
        return 0;
    }
}
