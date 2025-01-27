package com.github.vcvitaly._216;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSum3FinderTest {

    private final CombinationSum3Finder finder = new CombinationSum3Finder();

    @Test
    void test1() {
        assertThat(finder.combinationSum3(3, 7)).isEqualTo(List.of(List.of(1,2,4)));
    }

    @Test
    void test2() {
        assertThat(finder.combinationSum3(3, 9))
                .isEqualTo(List.of(List.of(1,2,6),List.of(1,3,5),List.of(2,3,4)));
    }

    @Test
    void test3() {
        assertThat(finder.combinationSum3(3, 10))
                .isEqualTo(List.of(
                        List.of(1,2,7),
                        List.of(1,3,6),
                        List.of(1,4,5),
                        List.of(2,3,5)
                ));
    }

    @Test
    void test4() {
        assertThat(finder.combinationSum3(4, 1)).isEqualTo(List.of());
    }
}