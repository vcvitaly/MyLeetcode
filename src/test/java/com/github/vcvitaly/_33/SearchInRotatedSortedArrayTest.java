package com.github.vcvitaly._33;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SearchInRotatedSortedArrayTest.
 *
 * @author Vitalii Chura
 */
class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();

    @Test
    void test1() {
        int targetIndex = search.search(new int[] {4,5,6,7,0,1,2}, 0);
        assertThat(targetIndex).isEqualTo(4);
    }

    @Test
    void test2() {
        int targetIndex = search.search(new int[] {4,5,6,7,0,1,2}, 3);
        assertThat(targetIndex).isEqualTo(-1);
    }

    @Test
    void test3() {
        int targetIndex = search.search(new int[] {1}, 0);
        assertThat(targetIndex).isEqualTo(-1);
    }

    @Test
    void test4() {
        int targetIndex = search.search(new int[] {1,2,3}, 3);
        assertThat(targetIndex).isEqualTo(2);
    }

    @Test
    void test5() {
        int targetIndex = search.search(new int[] {1,3}, 1);
        assertThat(targetIndex).isEqualTo(0);
    }

    @Test
    void test6() {
        int targetIndex = search.search(new int[] {1,3}, 2);
        assertThat(targetIndex).isEqualTo(-1);
    }

    @Test
    void test7() {
        int targetIndex = search.search(new int[] {3,1}, 1);
        assertThat(targetIndex).isEqualTo(1);
    }

    @Test
    void test8() {
        int targetIndex = search.search(new int[] {1,3,5}, 3);
        assertThat(targetIndex).isEqualTo(1);
    }

    @Test
    void test9() {
        int targetIndex = search.search(new int[] {4,5,1,2,3}, 1);
        assertThat(targetIndex).isEqualTo(2);
    }

    @Test
    void test10() {
        int targetIndex = search.search(new int[] {3,1,2}, 2);
        assertThat(targetIndex).isEqualTo(2);
    }

    @Test
    void test11() {
        int targetIndex = search.search(new int[] {5,1,2,3,4}, 4);
        assertThat(targetIndex).isEqualTo(4);
    }

    @Test
    void test12() {
        int targetIndex = search.search(new int[] {1,2,3,4,5}, 1);
        assertThat(targetIndex).isEqualTo(0);
    }

    @Test
    void test13() {
        int targetIndex = search.search(new int[] {5,1,2,3,4}, 5);
        assertThat(targetIndex).isEqualTo(0);
    }

    @Test
    void test14() {
        int targetIndex = search.search(IntStream.concat(IntStream.of(99,100), IntStream.rangeClosed(1,98)).toArray(), 1);
        assertThat(targetIndex).isEqualTo(2);
    }

    @Test
    void test15() {
        int targetIndex = search.search(new int[] {3,4,5,1,2}, 2);
        assertThat(targetIndex).isEqualTo(4);
    }
}