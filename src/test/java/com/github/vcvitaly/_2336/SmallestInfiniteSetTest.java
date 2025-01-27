package com.github.vcvitaly._2336;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestInfiniteSetTest {

    private final SmallestInfiniteSet s = new SmallestInfiniteSet();

    @Test
    void test1() {
        s.addBack(2);
        assertThat(s.popSmallest()).isEqualTo(1);
        assertThat(s.popSmallest()).isEqualTo(2);
        assertThat(s.popSmallest()).isEqualTo(3);
        s.addBack(1);
        assertThat(s.popSmallest()).isEqualTo(1);
        assertThat(s.popSmallest()).isEqualTo(4);
        assertThat(s.popSmallest()).isEqualTo(5);
    }

    @Test
    void test2() {
        assertThat(s.popSmallest()).isEqualTo(1);
        s.addBack(1);
        assertThat(s.popSmallest()).isEqualTo(1);
        assertThat(s.popSmallest()).isEqualTo(2);
        assertThat(s.popSmallest()).isEqualTo(3);
        s.addBack(2);
        s.addBack(3);
        assertThat(s.popSmallest()).isEqualTo(2);
        assertThat(s.popSmallest()).isEqualTo(3);
    }
}