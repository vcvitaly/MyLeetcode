package com.github.vcvitaly._1046;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LastStoneWeight.
 *
 * @author Vitalii Chura
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }

        Queue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stoneWeight : stones) {
            pQ.add(stoneWeight);
        }

        while (pQ.size() > 1) {
            int stoneWeight1 = pQ.remove();
            int stoneWeight2 = pQ.remove();
            int biggerStoneWeight = Math.max(stoneWeight1, stoneWeight2);
            int smallerStoneWeight = Math.min(stoneWeight1, stoneWeight2);
            if (biggerStoneWeight > smallerStoneWeight) {
                int newStoneWeight = biggerStoneWeight - smallerStoneWeight;
                pQ.offer(newStoneWeight);
            }
        }

        if (!pQ.isEmpty()) {
            return pQ.remove();
        }

        return 0;
    }
}
