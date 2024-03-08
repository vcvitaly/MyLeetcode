package com.github.vcvitaly._24;

import com.github.vcvitaly.common.ListNode;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.github.vcvitaly.util.ListUtil.getIntegers;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * SwapNodesInPairsTest.
 *
 * @author Vitalii Chura
 */
class SwapNodesInPairsTest {

    private SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

    @ParameterizedTest
    @MethodSource("params")
    void nodesInPairsAreSwapped(Param p) {
        System.out.printf("(head=%s, result=%s)%n", getIntegers(p.head), p.result);

        ListNode resultHead = swapNodesInPairs.swapPairs(p.head);
        List<Integer> result = getIntegers(resultHead);
        assertThat(result).containsExactlyElementsOf(p.result);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4)))),
                        List.of(2, 1, 4, 3)),
                Param.of(null, Collections.emptyList()),
                Param.of(new ListNode(1),
                        Collections.singletonList(1))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public ListNode head;
        private List<Integer> result;
    }
}