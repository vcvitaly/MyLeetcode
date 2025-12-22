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

    @Test
    void test4() {
        assertThat(calculator.jump(new int[]{1,1,1,1,1})).isEqualTo(4);
    }

    @Test
    void test5() {
        assertThat(calculator.jump(new int[]{4,6,8,1,1,1,1,1,1,1,1})).isEqualTo(2);
    }

    @Test
    void test6() {
        assertThat(calculator.jump(new int[]{3,3,3,3,3,3,3,3,3})).isEqualTo(3);
    }

    @Test
    void test7() {
        assertThat(calculator.jump(new int[]{0})).isZero();
    }

    @Test
    void test8() {
        assertThat(calculator.jump(new int[]{1,1})).isEqualTo(1);
    }

    @Test
    void test9() {
        assertThat(calculator.jump(new int[]{5,4,3,2,1,2,1,1})).isEqualTo(2);
    }
}