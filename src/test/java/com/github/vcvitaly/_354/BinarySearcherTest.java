package com.github.vcvitaly._354;


import org.junit.jupiter.api.Test;

import static com.github.vcvitaly._354.RussianDollEnvelopeSolver.*;
import static org.assertj.core.api.Assertions.assertThat;

class BinarySearcherTest {

    @Test
    void test1() {
        int[][] envelopes = {{2, 3}, {2, 2}, {2, 1}};
        assertThat(BinarySearcher.smallestHeightBiggerThan(
                envelopes, 4, 0, 2
        )).isEqualTo(-1);
        assertThat(BinarySearcher.smallestHeightBiggerThan(
                envelopes, 2, 0, 2
        )).isEqualTo(3);
        assertThat(BinarySearcher.smallestHeightBiggerThan(
                envelopes, 1, 0, 2
        )).isEqualTo(2);
    }
}
