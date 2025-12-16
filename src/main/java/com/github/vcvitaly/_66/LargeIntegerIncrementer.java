package com.github.vcvitaly._66;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargeIntegerIncrementer {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] > 9) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        return IntStream.concat(
                IntStream.of(1),
                Arrays.stream(digits)
        ).toArray();
    }
}
