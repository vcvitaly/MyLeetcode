package com.github.vcvitaly._1657;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringClosenessDeterminatorTest {

    private final StringClosenessDeterminator determinator = new StringClosenessDeterminator();

    @Test
    void test1() {
        assertThat(determinator.closeStrings("abc", "bca")).isTrue();
    }

    @Test
    void test2() {
        assertThat(determinator.closeStrings("a", "aa")).isFalse();
    }

    @Test
    void test3() {
        assertThat(determinator.closeStrings("cabbba", "aabbccca")).isTrue();
    }
}