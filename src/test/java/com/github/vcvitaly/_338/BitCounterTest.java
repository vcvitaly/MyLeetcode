package com.github.vcvitaly._338;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BitCounterTest {

    private BitCounter bitCounter = new BitCounter();

    @Test
    void test1() {
        assertThat(bitCounter.countBits(2))
                .containsExactly(0,1,1);
    }

    @Test
    void test2() {
        assertThat(bitCounter.countBits(5))
                .containsExactly(0,1,1,2,1,2);
    }

    @Test
    void test3() {
        assertThat(bitCounter.countBits(0))
                .containsExactly(0);
    }

    @Test
    void test4() {
        assertThat(bitCounter.countBits(4))
                .containsExactly(0,1,1,2,1);
    }
}