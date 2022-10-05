package com.github.vcvitaly._70;

/**
 * ClimbingStairs.
 *
 * @author Vitalii Chura
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int x = 1;
        int y = 2;
        for (int i = 2; i < n; i++) {
            int tmp = y;
            y = y + x;
            x = tmp;
        }
        return y;
    }
}
