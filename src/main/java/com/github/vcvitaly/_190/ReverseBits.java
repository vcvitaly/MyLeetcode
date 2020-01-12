package com.github.vcvitaly._190;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int j = (31-i);
            int ibit = (n >> i) & 1;
            int jbit = (n >> j) & 1;
            n = (n & ~(1 << i)) | (jbit << i);
            n = (n & ~(1 << j)) | (ibit << j);
        }
        return n;
    }
}
