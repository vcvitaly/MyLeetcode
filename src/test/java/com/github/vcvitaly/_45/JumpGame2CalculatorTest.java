package com.github.vcvitaly._45;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGame2CalculatorTest {

    private final JumpGame2Calculator calculator = new JumpGame2Calculator();

    @Test
    void test1() {
        assertThat(calculator.jump(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(calculator.jump(new int[]{2,3,1,1,4})).isEqualTo(2);
    }

    @Test
    void test3() {
        assertThat(calculator.jump(new int[]{2,3,0,1,4})).isEqualTo(2);
    }
}