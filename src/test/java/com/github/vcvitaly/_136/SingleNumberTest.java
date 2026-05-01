package com.github.vcvitaly._136;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleNumberTest {

    @Test
    void test1() {
        Assertions.assertThat(
                SingleNumber.singleNumber(new int[] {2, 2, 1})
        ).isEqualTo(1);
    }

    @Test
    void test2() {
        Assertions.assertThat(
                SingleNumber.singleNumber(new int[] {4, 1, 2, 1, 2})
        ).isEqualTo(4);
    }

    @Test
    void test3() {
        Assertions.assertThat(
                SingleNumber.singleNumber(new int[] {1})
        ).isEqualTo(1);
    }
}