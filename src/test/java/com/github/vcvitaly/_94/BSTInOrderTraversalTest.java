package com.github.vcvitaly._94;

import com.github.vcvitaly.common.TreeNode;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BSTInOrderTraversalTest.
 *
 * @author Vitalii Chura
 */
class BSTInOrderTraversalTest {

    private BSTInOrderTraversal bstInOrderTraversal = new BSTInOrderTraversal();

    @ParameterizedTest
    @MethodSource("params")
    void traversesATreeInOrder(Param p) {
        System.out.println(p);

        assertThat(bstInOrderTraversal.inorderTraversal(p.root)).containsExactlyElementsOf(p.result);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)),
                        List.of(1, 3, 2)),
                Param.of(new TreeNode(1),
                        List.of(1))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public TreeNode root;
        private List<Integer> result;
    }
}