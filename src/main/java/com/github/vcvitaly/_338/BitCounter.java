package com.github.vcvitaly._338;

import java.util.HashSet;
import java.util.Set;

public class BitCounter {

    public int[] countBits(int n) {
        if (n <= 0) {
            return new int[] {0};
        }
        if (n == 1) {
            return new int[] {0,1};
        }
        if (n == 2) {
            return new int[] {0,1,1};
        }

        final Set<Integer> powsOfTwo = new HashSet<>();
        int x = 2;
        while (x <= n) {
            powsOfTwo.add(x);
            x *= 2;
        }

        final int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 1;
        int prevPowOfTwo = 2;
        for (int i = 2; i <= n; i++) {
            if (powsOfTwo.contains(i)) {
                result[i] = 1;
                prevPowOfTwo = i;
            } else {
                result[i] = result[prevPowOfTwo] + result[i - prevPowOfTwo];
            }
        }

        return result;
    }
}
