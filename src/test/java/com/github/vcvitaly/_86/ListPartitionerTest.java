package com.github.vcvitaly._86;

import com.github.vcvitaly.common.ListNode;
import com.github.vcvitaly.util.ListUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListPartitionerTest {

    private final ListPartitioner partitioner = new ListPartitioner();

    @Test
    void test1() {
        ListNode partitioned = partitioner.partition(ListUtil.buildLinkedList(new int[]{1, 4, 3, 2, 5, 2}), 3);
        assertThat(ListUtil.getIntegers(partitioned))
                .containsExactly(1,2,2,4,3,5);
    }

    @Test
    void test2() {
        ListNode partitioned = partitioner.partition(ListUtil.buildLinkedList(new int[]{2,1}), 2);
        assertThat(ListUtil.getIntegers(partitioned))
                .containsExactly(1,2);
    }

    @Test
    void test3() {
        ListNode partitioned = partitioner.partition(ListUtil.buildLinkedList(new int[]{3,4,1,2}), 3);
        assertThat(ListUtil.getIntegers(partitioned))
                .containsExactly(1,2,3,4);
    }

    @Test
    void test4() {
        ListNode partitioned = partitioner.partition(ListUtil.buildLinkedList(new int[]{1,2,3,4}), 3);
        assertThat(ListUtil.getIntegers(partitioned))
                .containsExactly(1,2,3,4);
    }
}