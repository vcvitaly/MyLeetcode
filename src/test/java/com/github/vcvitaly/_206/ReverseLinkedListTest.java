package com.github.vcvitaly._206;

import com.github.vcvitaly.common.ListNode;
import com.github.vcvitaly.util.ListUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ReverseLinkedListTest.
 *
 * @author Vitalii Chura
 */
class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    @ParameterizedTest
    @MethodSource("params")
    void linkedListIsReversed(Param p) {
        System.out.println(p);

        ListNode reverseList = reverseLinkedList.reverseList(p.head);
        List<Integer> integers = ListUtil.getIntegers(reverseList);
        assertThat(integers).containsExactlyElementsOf(p.reversedListIntegers);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5))))),
                        List.of(5,4,3,2,1)
                )
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private ListNode head;
        private List<Integer> reversedListIntegers;
    }
}