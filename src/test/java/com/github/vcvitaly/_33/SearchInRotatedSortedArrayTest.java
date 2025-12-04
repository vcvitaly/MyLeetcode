package com.github.vcvitaly._33;

import org.junit.jupiter.api.Test;

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
}