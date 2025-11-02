package com.github.vcvitaly._354;

import java.util.*;

public class RussianDollEnvelopeSolver {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }

        Arrays.sort(
                envelopes,
                Comparator.comparingInt(RussianDollEnvelopeSolver::width).thenComparingInt((int[] envolope) -> -height(envolope))
        );

        final int initialWidthSeqLength = initialWidthSeqLength(envelopes);
        if (initialWidthSeqLength == envelopes.length) {
            return 1;
        }

        final int[] fittingEnvelopeCounts = new int[envelopes.length];
        Arrays.fill(fittingEnvelopeCounts, 1);

        final int initialWidth = width(envelopes[0]);
        int maxEnvelopes = 1;
        int sameWidthLeftIndex = -1;
        int sameWidthRightIndex = -1;
        for (int i = initialWidthSeqLength; i < envelopes.length; i++) {
            if (width(envelopes[i]) > width(envelopes[i-1])) {
                if (i == initialWidthSeqLength) {

                }
            }
        }
        return maxEnvelopes;
    }

    private static int width(int[] envelope) {
        return envelope[0];
    }

    private static int height(int[] envelope) {
        return envelope[1];
    }

    private int initialWidthSeqLength(int[][] envelopes) {
        int length = 0;
        final int initialWidth = width(envelopes[0]);
        for (int[] envelope : envelopes) {
            if (width(envelope) == initialWidth) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    static class BinarySearcher {

        private BinarySearcher() {}

        static int smallestHeightBiggerThan(int[][] envelopes, int height, int from, int to) {
            int left = from;
            int right = to;
            int smallestBiggerHeight = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int h = height(envelopes[mid]);
                if (h > height) {
                    smallestBiggerHeight = h;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return smallestBiggerHeight;
        }
    }
}
