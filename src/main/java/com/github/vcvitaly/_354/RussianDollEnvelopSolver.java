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
        RussianDollEnvelope prevIncluded = null;
        for (RussianDollEnvelope envelop : envelopObjects) {
            if (fits(prev, envelop) || fits(prevIncluded, envelop)) {
                maxEnvelopes++;
                prevIncluded = envelop;
            }
            prev = envelop;
        }
        return maxEnvelopes;
    }

    private boolean fits(RussianDollEnvelope prev, RussianDollEnvelope envelop) {
        return prev == null || envelop.compareTo(prev) < 0 && envelop.height() < prev.height() && envelop.width() < prev.width();
    }

    private record RussianDollEnvelope(int width, int height) implements Comparable<RussianDollEnvelope> {
        @Override
        public int compareTo(RussianDollEnvelope o) {
            final int hComparison = Comparator.comparingInt(RussianDollEnvelope::height)
                    .compare(this, o);
            final int wComparison = Comparator.comparingInt(RussianDollEnvelope::width)
                    .compare(this, o);
            if (hComparison > 0 &&  wComparison > 0) {
                return 1;
            }
            if (hComparison == 0 && wComparison == 0) {
                return 0;
            }
            if (hComparison < 0 && wComparison < 0) {
                return -1;
            }
            return Comparator.comparingInt((RussianDollEnvelope rde) -> rde.height() + rde.width()).compare(this, o);
        }
    }
}
