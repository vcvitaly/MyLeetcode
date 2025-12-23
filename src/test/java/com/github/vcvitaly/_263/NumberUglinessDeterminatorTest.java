package com.github.vcvitaly._263;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUglinessDeterminatorTest {

    private final NumberUglinessDeterminator determinator = new NumberUglinessDeterminator();

    @Test
    void test1() {
        assertThat(determinator.isUgly(1)).isTrue();
    }

    @Test
    void test2() {
        assertThat(determinator.isUgly(6)).isTrue();
    }

    @Test
    void test3() {
        assertThat(determinator.isUgly(14)).isFalse();
    }

    @Test
    void test4() {
        assertThat(determinator.isUgly(8)).isTrue();
    }

    @Test
    void test5() {
        assertThat(determinator.isUgly(11)).isFalse();
    }

    @Test
    void test6() {
        assertThat(determinator.isUgly(22)).isFalse();
    }
}