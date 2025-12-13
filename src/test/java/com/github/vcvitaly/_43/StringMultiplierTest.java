package com.github.vcvitaly._43;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringMultiplierTest {

    private final StringMultiplier multiplier = new StringMultiplier();

    @Test
    void test1() {
        String actualResult = multiplier.multiply("2", "3");

        assertThat(actualResult).isEqualTo("6");
    }

    @Test
    void test2() {
        String actualResult = multiplier.multiply("123","456");

        assertThat(actualResult).isEqualTo("56088");
    }

    @Test
    void test3() {
        String actualResult = multiplier.multiply("0","1");

        assertThat(actualResult).isEqualTo("0");
    }

    @Test
    void test4() {
        String actualResult = multiplier.multiply("1","1");

        assertThat(actualResult).isEqualTo("1");
    }

    @Test
    void test5() {
        String actualResult = multiplier.multiply("123456789","987654321");

        assertThat(actualResult).isEqualTo("121932631112635269");
    }
}