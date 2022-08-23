package com.github.vcvitaly._83;

import com.github.vcvitaly.common.ListNode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RemoveDuplicatesFromSortedListTest.
 *
 * @author Vitalii Chura
 */
class RemoveDuplicatesFromSortedListTest {

    private RemoveDuplicatesFromSortedList duplicateRemover = new RemoveDuplicatesFromSortedList();

    @ParameterizedTest
    @MethodSource("params")
    void removesDuplicatesFromALinkedList(Param p) {
        System.out.println(p);

        List<Integer> result = new ArrayList<>();
        ListNode resultHead = duplicateRemover.deleteDuplicates(p.head);
        while (resultHead != null) {
            result.add(resultHead.val);
            resultHead = resultHead.next;
        }
        assertThat(result).containsExactlyElementsOf(p.result);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2))),
                        List.of(1, 2)),
                Param.of(new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3,
                                                        new ListNode(3))))),
                        List.of(1, 2, 3)),
                Param.of(new ListNode(1,
                                new ListNode(1)),
                        List.of(1))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public ListNode head;
        private List<Integer> result;
    }
}