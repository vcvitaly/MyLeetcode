package com.github.vcvitaly._38;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountSaySeqFinderTest {

    private final CountSaySeqFinder finder = new CountSaySeqFinder();

    @Test
    void test1() {
        assertThat(finder.countAndSay(4)).isEqualTo("1211");
    }

    @Test
    void test2() {
        assertThat(finder.countAndSay(1)).isEqualTo("1");
    }

    @Test
    void test3() {
        assertThat(finder.countAndSay(5)).isEqualTo("111221");
    }
}