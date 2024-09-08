package com.github.vcvitaly._7;

public class IntegerReverser {

    private static final int OVERFLOW_POINT = Integer.MAX_VALUE / 10;

    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int tmpX = Math.abs(x);
        int res = 0;
        while (tmpX > 0) {
            if (res > OVERFLOW_POINT) {
                return 0;
            }
            int remainder = tmpX % 10;
            res = (res * 10) + remainder;
            tmpX = tmpX / 10;
        }

        return x >= 0 ? res : -res;
    }
}
