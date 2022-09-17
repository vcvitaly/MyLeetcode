package com.github.vcvitaly._121;

/**
 * BestTimeToBuyAndSellStock.
 *
 * @author Vitalii Chura
 */
public class BestTimeToBuyAndSellStock {

    // solution is not mine
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,
            max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }

        return max;
    }

    public int maxProfitSlow(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int maxPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int difference = prices[j] - prices[i];
                if (difference > maxPrice) {
                    maxPrice = difference;
                }
            }
        }

        return maxPrice;
    }
}
