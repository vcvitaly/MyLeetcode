package com.github.vcvitaly._171;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExcelColNumCalculatorTest {

    private final ExcelColNumCalculator calculator = new ExcelColNumCalculator();

    @Test
    void test1() {
        assertThat(calculator.titleToNumber("A")).isEqualTo(1);
    }

    @Test
    void test2() {
        assertThat(calculator.titleToNumber("AB")).isEqualTo(28);
    }

    @Test
    void test3() {
        assertThat(calculator.titleToNumber("ZY")).isEqualTo(701);
    }

    @Test
    void test4() {
        assertThat(calculator.titleToNumber("AAA")).isEqualTo(703);
    }

    @Test
    void test5() {
        assertThat(calculator.titleToNumber("BA")).isEqualTo(53);
    }
}