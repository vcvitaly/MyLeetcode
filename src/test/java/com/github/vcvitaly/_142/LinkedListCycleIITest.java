package com.github.vcvitaly._142;

import com.github.vcvitaly.common.ListNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.future;

/**
 * LinkedListCycleIITest.
 *
 * @author Vitalii Chura
 */
class LinkedListCycleIITest {

    private LinkedListCycleII linkedListCycleII = new LinkedListCycleII();

    @ParameterizedTest
    @MethodSource("params")
    void nodeWhichBeginsACycleIsReturned(Param p) {
        System.out.println(p);

        ListNode nodeWhichBeginsACycle = linkedListCycleII.detectCycle(p.head);
        assertThat(nodeWhichBeginsACycle.val).isEqualTo(p.valueWhichBeginsACycle);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(testCaseOne(), 1),
                Param.of(testCaseTwo(), 2),
                Param.of(testCaseThree(), -9)
        );
    }

    private static ListNode testCaseOne() {
        ListNode nodeZero = new ListNode(1);
        ListNode nodeOne = new ListNode(2);

        nodeZero.next = nodeOne;
        nodeOne.next = nodeZero;

        return nodeZero;
    }

    private static ListNode testCaseTwo() {
        ListNode nodeZero = new ListNode(3);
        ListNode nodeOne = new ListNode(2);
        ListNode nodeTwo = new ListNode(0);
        ListNode nodeThree = new ListNode(-4);

        nodeZero.next = nodeOne;
        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeOne;

        return nodeZero;
    }

    private static ListNode testCaseThree() {
        ListNode nodeZero = new ListNode(-1);
        ListNode nodeOne = new ListNode(-7);
        ListNode nodeTwo = new ListNode(7);
        ListNode nodeThree = new ListNode(-4);
        ListNode nodeFour = new ListNode(19);
        ListNode nodeFive = new ListNode(6);
        ListNode nodeSix = new ListNode(-9);
        ListNode nodeSeven = new ListNode(-5);
        ListNode nodeEight = new ListNode(-2);
        ListNode nodeNine = new ListNode(-5);

        nodeZero.next = nodeOne;
        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;
        nodeSeven.next = nodeEight;
        nodeEight.next = nodeNine;
        nodeNine.next = nodeSix;

        return nodeZero;
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private ListNode head;
        private int valueWhichBeginsACycle;
    }
}