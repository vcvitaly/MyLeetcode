package com.github.vcvitaly._66;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LargeIntegerIncrementerTest {

    private final LargeIntegerIncrementer incrementer = new LargeIntegerIncrementer();

    @Test
    void test1() {
        assertThat(incrementer.plusOne(new int[] {1, 2, 3}))
                .containsExactly(1, 2, 4);
    }

    @Test
    void test2() {
        assertThat(incrementer.plusOne(new int[] {4, 3, 2, 1}))
                .containsExactly(4, 3, 2, 2);
    }

    @Test
    void test3() {
        assertThat(incrementer.plusOne(new int[] {9}))
                .containsExactly(1, 0);
    }

    @Test
    void test4() {
        assertThat(incrementer.plusOne(new int[] {0}))
                .containsExactly(1);
    }

    @Test
    void test5() {
        assertThat(incrementer.plusOne(new int[] {1,9,9,9,9,9,9,9,9,9}))
                .containsExactly(2,0,0,0,0,0,0,0,0,0);
    }
}