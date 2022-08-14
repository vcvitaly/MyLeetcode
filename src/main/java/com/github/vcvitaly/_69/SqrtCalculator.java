package com.github.vcvitaly._69;

/**
 * SqrtCalculator.
 *
 * @author Vitalii Chura
 */
public class SqrtCalculator {

    public int mySqrt(int x) {

        int l = 0;
        int r = x;

        while (l <= r) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int mid = (l + r) / 2;
//            if (mid*mid)
        }

        return 0;
    }
}
