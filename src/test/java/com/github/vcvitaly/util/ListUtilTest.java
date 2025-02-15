package com.github.vcvitaly.util;

import com.github.vcvitaly.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListUtilTest {

    @Test
    void unwrapsList() {
        assertThat(ListUtil.getIntegers(
                new ListNode(
                        1, new ListNode(
                                2, new ListNode(3)
                        )
                )
        )).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void buildsLinkedList() {
        assertThat(ListUtil.getIntegers(ListUtil.buildLinkedList(new int[] {1,2,3})))
                .isEqualTo(List.of(1,2,3));
    }

    @Test
    void buildsLinkedListWithOneElement() {
        assertThat(ListUtil.getIntegers(ListUtil.buildLinkedList(new int[] {1})))
                .isEqualTo(List.of(1));
    }
}