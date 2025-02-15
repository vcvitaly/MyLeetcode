package com.github.vcvitaly._25;

import com.github.vcvitaly.util.ListUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KGroupNodeReverserTest {


    private final KGroupNodeReverser reverser = new KGroupNodeReverser();

    @Test
    void test1() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1,2,3,4,5}), 2
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {2,1,4,3,5}));
    }

    @Test
    void test1_1() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1,2,3,4,5,6,7,8,9}), 2
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {2,1,4,3,6,5,8,7,9}));
    }

    @Test
    void test2() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1,2,3,4,5}), 3
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {3,2,1,4,5}));
    }

    @Test
    void test3() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1}), 1
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {1}));
    }

    @Test
    void test4() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1,2}), 1
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {1,2}));
    }

    @Test
    void test4_1() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1,2}), 2
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {2,1}));
    }

    @Test
    void test4_2() {
        assertThat(reverser.reverseKGroup(
                ListUtil.buildLinkedList(new int[] {1,2}), 3
        )).isEqualTo(ListUtil.buildLinkedList(new int[] {2,1}));
    }
}