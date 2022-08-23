package com.github.vcvitaly._82;

import com.github.vcvitaly.common.ListNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RemoveDuplicatesFromSortedListIITest.
 *
 * @author Vitalii Chura
 */
class RemoveDuplicatesFromSortedListIITest {

    private RemoveDuplicatesFromSortedListII duplicateRemover = new RemoveDuplicatesFromSortedListII();

    @ParameterizedTest
    @MethodSource("params")
    void removesDuplicatesFromALinkedList(Param p) {
        System.out.println(String.format("(head=%s, result=%s)", getIntegers(p.head), p.result));

        ListNode resultHead = duplicateRemover.deleteDuplicates(p.head);
        List<Integer> result = getIntegers(resultHead);
        assertThat(result).containsExactlyElementsOf(p.result);
    }

    private static List<Integer> getIntegers(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }


    static Stream<Param> params() {
        return Stream.of(
                Param.of(new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2))),
                        List.of(2)),
                Param.of(new ListNode(1,
                                new ListNode(1,
                                        new ListNode(1,
                                                new ListNode(2,
                                                        new ListNode(3))))),
                        List.of(2, 3)),
                Param.of(new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(3,
                                                        new ListNode(4,
                                                                new ListNode(4, new ListNode(5))))))),
                        List.of(1, 2, 5)),
                Param.of(new ListNode(1,
                                new ListNode(2,
                                        new ListNode(2))),
                        List.of(1)),
                Param.of(new ListNode(1,
                                new ListNode(1)),
                        Collections.emptyList()),
                Param.of(new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(2)))),
                        Collections.emptyList())
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public ListNode head;
        private List<Integer> result;
    }
}