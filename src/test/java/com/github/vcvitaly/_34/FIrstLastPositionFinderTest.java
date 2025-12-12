package com.github.vcvitaly._34;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FIrstLastPositionFinderTest {

    private final FIrstLastPositionFinder finder = new FIrstLastPositionFinder();

    @Test
    void test1() {
        assertThat(finder.searchRange(new int[] {5,7,7,8,8,10}, 8))
                .containsExactly(3,4);
    }

    @Test
    void test2() {
        assertThat(finder.searchRange(new int[] {5,7,7,8,8,10}, 6))
                .containsExactly(-1,-1);
    }

    @Test
    void test3() {
        assertThat(finder.searchRange(new int[] {}, 0))
                .containsExactly(-1,-1);
    }

    @Test
    void test4() {
        assertThat(finder.searchRange(new int[] {5,7,7,8,8,10}, 7))
                .containsExactly(1,2);
    }

    @Test
    void test5() {
        assertThat(finder.searchRange(new int[] {1,1,1}, 1))
                .containsExactly(0,2);
    }

    @Test
    void test6() {
        assertThat(finder.searchRange(new int[] {1,1,1}, 0))
                .containsExactly(-1,-1);
    }
}