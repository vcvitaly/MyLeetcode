package com.github.vcvitaly._121;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BestTimeToBuyAndSellStockTest.
 *
 * @author Vitalii Chura
 */
class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

    @ParameterizedTest
    @MethodSource("params")
    void maxPriceIsFound(Param p) {
        System.out.println(p);

        int maxProfit = bestTimeToBuyAndSellStock.maxProfit(p.prices);
        assertThat(maxProfit).isEqualTo(p.maxProfit);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(
                        new int[] {7,1,5,3,6,4}, 5
                ),
                Param.of(
                        new int[] {7,6,4,3,1}, 0
                )
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private int[] prices;
        private int maxProfit;
    }

}