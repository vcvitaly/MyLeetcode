package com.github.vcvitaly._78;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetGeneratorTest {

    private final SubsetGenerator subsetGenerator = new SubsetGenerator();

    @Test
    void test1() {
        assertThat(subsetGenerator.subsets(new int[] {1,2,3}))
                .containsExactlyInAnyOrder(
                        List.of(),
                        List.of(1),
                        List.of(2),
                        List.of(1, 2),
                        List.of(3),
                        List.of(1, 3),
                        List.of(2, 3),
                        List.of(1, 2, 3)
                );
    }
}