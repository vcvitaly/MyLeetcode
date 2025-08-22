package com.github.vcvitaly._370;

class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        final int[] res = new int[length];
        for (int[] updateArgs : updates) {
            final int startIdx = updateArgs[0];
            final int endIdx = updateArgs[1];
            final int inc = updateArgs[2];
            for (int i = startIdx; i <= endIdx; i++) {
                res[i] += inc;
            }
        }
        return res;
    }
}
