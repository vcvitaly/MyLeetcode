package com.github.vcvitaly._228;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SummaryRangesFinderTest {

    private SummaryRangesFinder finder;

    @BeforeEach
    void setUp() {
        finder = new SummaryRangesFinder();
    }

    @Test
    void testExample1() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).containsExactly("0->2", "4->5", "7");
    }

    @Test
    void testExample2() {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).containsExactly("0", "2->4", "6", "8->9");
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).isEmpty();
    }

    @Test
    void testNullArray() {
        List<String> result = finder.summaryRanges(null);
        assertThat(result).isEmpty();
    }

    @Test
    void testSingleElement() {
        int[] nums = {5};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).containsExactly("5");
    }

    @Test
    void testMultipleDisjointRanges() {
        int[] nums = {1, 3, 5, 7};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).containsExactly("1", "3", "5", "7");
    }

    @Test
    void testContinuousRange() {
        int[] nums = {1, 2, 3, 4, 5};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).containsExactly("1->5");
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-5, -4, -3, 0, 1, 2, 5};
        List<String> result = finder.summaryRanges(nums);
        assertThat(result).containsExactly("-5->-3", "0->2", "5");
    }

}