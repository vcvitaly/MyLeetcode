package com.github.vcvitaly._1431;

import java.util.ArrayList;
import java.util.List;

public class CandySolver {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        final List<Boolean> result = new ArrayList<>(candies.length);
        int max = 0;
        for (int candiesCount : candies) {
            if (candiesCount > max) {
                max = candiesCount;
            }
        }
        for (int candiesCount : candies) {
            final int plusExtra = candiesCount + extraCandies;
            result.add(plusExtra >= max);
        }
        return result;
    }
}
