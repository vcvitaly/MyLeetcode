package com.github.vcvitaly._135;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

// WIP
public class CandyDistributionSolver {

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        if (ratings.length == 2) {
            return ratings[0] == ratings[1] ? 2 : 3;
        }

        final List<RatingTrend> trends = ratingTrends(ratings);

        return IntStream.range(0, trends.size())
                .map(i -> {
                    if (i == 0) {
                        return countCandiesInTrend(ratings, null, trends.get(i));
                    }
                    return countCandiesInTrend(ratings, trends.get(i - 1), trends.get(i));
                }).sum();
    }

    private int countCandiesInTrend(int[] ratings, RatingTrend prev, RatingTrend trend) {
        int from = trend.from();
        int to = trend.to();

        TrendType type = trend.trendType();
        if (type == TrendType.EQUALITY) {
            return to - from + 1;
        }

        int candies = 0;
        int currentChildCandies = 0;
        if (prev != null && prev.trendType() == TrendType.DECREASING &&
                type == TrendType.INCREASING && ratings[prev.to()] < ratings[trend.from()]) {
            currentChildCandies++;
        }
        int i = 0;
        while (i <= to - from) {
            currentChildCandies++;
            candies += currentChildCandies;
            i++;
        }

        return candies;
    }

    private List<RatingTrend> ratingTrends(int[] ratings) {
        final List<RatingTrend> trends = new ArrayList<>();

        int from = 0;
        int to = 1;
        TrendType trendType = trendType(ratings, from, to);
        for (int i = 2; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                if (trendType == TrendType.INCREASING) {
                    to = i;
                } else {
                    trends.add(new RatingTrend(from, to, trendType));
                    from = i;
                    Map.Entry<Integer, TrendType> tuple = tuple(ratings, from);
                    to = tuple.getKey();
                    trendType = tuple.getValue();
                }
            } else if (ratings[i] < ratings[i-1]) {
                if (trendType == TrendType.DECREASING) {
                    to = i;
                } else {
                    trends.add(new RatingTrend(from, to, trendType));
                    from = i;
                    Map.Entry<Integer, TrendType> tuple = tuple(ratings, from);
                    to = tuple.getKey();
                    trendType = tuple.getValue();
                }
            } else {
                if (trendType == TrendType.EQUALITY) {
                    to = i;
                } else {
                    trends.add(new RatingTrend(from, to, trendType));
                    from = i;
                    Map.Entry<Integer, TrendType> tuple = tuple(ratings, from);
                    to = tuple.getKey();
                    trendType = tuple.getValue();
                }
            }
        }

        trends.add(new RatingTrend(from, to, trendType));

        return trends;
    }

    private Map.Entry<Integer, TrendType> tuple(int[] ratings, int from) {
        int to;
        TrendType trendType;
        if (from == ratings.length - 1) {
            to = from;
            trendType = TrendType.INCREASING;
        } else {
            to = from + 1;
            trendType = trendType(ratings, from, to);
        }
        return Map.entry(to, trendType);
    }

    private TrendType trendType(int[] ratings, int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("to must be gte than from");
        }
        if (ratings[to] > ratings[from]) {
            return TrendType.INCREASING;
        }
        return ratings[to] < ratings[from] ? TrendType.DECREASING : TrendType.EQUALITY;
    }

    private record RatingTrend(int from, int to, TrendType trendType) implements Comparable<RatingTrend> {
        @Override
        public int compareTo(RatingTrend o) {
            return Integer.compare(to - from + 1, o.to - from + 1);
        }
    }

    private enum TrendType {
        INCREASING,
        DECREASING,
        EQUALITY
    }
}
