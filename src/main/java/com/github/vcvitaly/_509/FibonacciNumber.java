package com.github.vcvitaly._509;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * FibonacciNumber.
 *
 * @author Vitalii Chura
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }
}
