package com.github.vcvitaly._42;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RainWaterTrapperTest {

    private final RainWaterTrapper trapper = new RainWaterTrapper();

    @Test
    void test1() {
        assertThat(trapper.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})).isEqualTo(6);
    }

    @Test
    void test2() {
        assertThat(trapper.trap(new int[] {4,2,0,3,2,5})).isEqualTo(9);
    }

    @Test
    void test2_1() {
        assertThat(trapper.trap(new int[] {4,2,0,3,2,5,0,3})).isEqualTo(12);
    }
}