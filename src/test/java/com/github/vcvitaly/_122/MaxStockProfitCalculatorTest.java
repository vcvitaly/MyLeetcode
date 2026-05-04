package com.github.vcvitaly._122;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxStockProfitCalculatorTest {

    private final MaxStockProfitCalculator calculator = new MaxStockProfitCalculator();

    @Test
    void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = calculator.maxProfit(prices);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        int result = calculator.maxProfit(prices);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        int result = calculator.maxProfit(prices);
        assertThat(result).isZero();
    }

}