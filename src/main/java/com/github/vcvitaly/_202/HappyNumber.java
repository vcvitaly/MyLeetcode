package com.github.vcvitaly._202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HappyNumber.
 *
 * @author Vitalii Chura
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            List<Integer> digits = toDigits(n);
            n = digits.stream()
                    .map(digit -> digit * digit)
                    .reduce(0, Integer::sum);
        }

        return n == 1;
    }

    private List<Integer> toDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }
}
