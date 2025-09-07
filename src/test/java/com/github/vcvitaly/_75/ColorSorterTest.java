package com.github.vcvitaly._75;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ColorSorterTest {

    private final ColorSorter sorter = new ColorSorter();

    @Test
    void test1() {
        int[] colors = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(colors);
        assertThat(colors).containsExactly(0,0,1,1,2,2);
    }

    @Test
    void test2() {
        int[] colors = {2, 0, 1};
        sorter.sortColors(colors);
        assertThat(colors).containsExactly(0,1,2);
    }
}