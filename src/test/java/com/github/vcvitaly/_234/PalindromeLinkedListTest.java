package com.github.vcvitaly._234;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PalindromeLinkedListTest.
 *
 * @author Vitalii Chura
 */
class PalindromeLinkedListTest {

    private PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    @ParameterizedTest
    @MethodSource("params")
    void checkIfALinkedListIsAPalindrome(Param p) {
        System.out.println(p);

        assertThat(palindromeLinkedList.isPalindrome(p.head)).isEqualTo(p.isPalindrome);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new ListNode(1,
                                new ListNode(2,
                                        new ListNode(2,
                                                new ListNode(1)))), true),
                Param.of(new ListNode(1, new ListNode(2)), false)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public ListNode head;
        private boolean isPalindrome;
    }
}