package com.github.vcvitaly._168;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExcelSheetColumnTitleConverterTest {

    private final ExcelSheetColumnTitleConverter converter = new ExcelSheetColumnTitleConverter();

    @Test
    void test1() {
        assertThat(converter.convertToTitle(1)).isEqualTo("A");
    }

    @Test
    void test2() {
        assertThat(converter.convertToTitle(28)).isEqualTo("AB");
    }

    @Test
    void test3() {
        assertThat(converter.convertToTitle(701)).isEqualTo("ZY");
    }

    @Test
    void test4() {
        assertThat(converter.convertToTitle(703)).isEqualTo("AAA");
    }

    @Test
    void test5() {
        assertThat(converter.convertToTitle(53)).isEqualTo("BA");
    }
}