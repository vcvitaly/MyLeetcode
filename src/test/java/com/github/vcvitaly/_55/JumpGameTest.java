package com.github.vcvitaly._55;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGameTest {

    private final JumpGame jumpGame = new JumpGame();

    @Test
    void test1() {
        assertThat(jumpGame.canJump(new int[]{2,3,1,1,4})).isTrue();
    }

    @Test
    void test2() {
        assertThat(jumpGame.canJump(new int[]{3,2,1,0,4})).isFalse();
    }

    @Test
    void test3() {
        assertThat(jumpGame.canJump(new int[]{0})).isTrue();
    }

    @Test
    void test4() {
        assertThat(jumpGame.canJump(new int[]{2,0,0})).isTrue();
    }

    @Test
    void test5() {
        assertThat(jumpGame.canJump(new int[]{1,2,3})).isTrue();
    }

    @Test
    void test6() {
        final int[] array = IntStream.range(0, 5000).map(i -> 1).toArray();
        assertThat(jumpGame.canJump(array)).isTrue();
    }
}