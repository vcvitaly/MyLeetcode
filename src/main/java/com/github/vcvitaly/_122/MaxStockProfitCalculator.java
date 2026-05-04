package com.github.vcvitaly._122;

public class MaxStockProfitCalculator {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                maxProfit += prices[i] - buyPrice;
            }
            buyPrice = prices[i];
        }
        return maxProfit;
    }
}
