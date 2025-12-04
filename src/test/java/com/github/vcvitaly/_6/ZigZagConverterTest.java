package com.github.vcvitaly._6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZigZagConverterTest {

    private final ZigZagConverter converter = new ZigZagConverter();

    @Test
    void test1() {
        assertThat(converter.convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
    }

    @Test
    void test2() {
        assertThat(converter.convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
    }

    @Test
    void test3() {
        assertThat(converter.convert("A", 1)).isEqualTo("A");
    }
}