package com.github.vcvitaly._354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RussianDollEnvelopSolver {

    public int maxEnvelopes(int[][] envelopes) {
        final List<RussianDollEnvelope> envelopObjects = Arrays.stream(envelopes)
                .map(e -> new RussianDollEnvelope(e[0], e[1]))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
        int maxEnvelopes = 0;
        RussianDollEnvelope prev = null;
        for (RussianDollEnvelope envelop : envelopObjects) {
            if (prev == null || envelop.compareTo(prev) < 0) {
                maxEnvelopes++;
            }
            prev = envelop;
        }
        return maxEnvelopes;
    }

    private record RussianDollEnvelope(int width, int height) implements Comparable<RussianDollEnvelope> {
        @Override
        public int compareTo(RussianDollEnvelope o) {
            return Comparator.comparingInt(RussianDollEnvelope::height)
                    .thenComparingInt(RussianDollEnvelope::width)
                    .compare(this, o);
        }
    }
}
