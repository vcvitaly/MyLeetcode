package com.github.vcvitaly._257;

import com.github.vcvitaly.common.TreeNode;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * BinaryTreePathsTest.
 *
 * @author Vitalii Chura
 */
class BinaryTreePathsTest {

    private BinaryTreePaths binaryTreePaths = new BinaryTreePaths();

    @ParameterizedTest
    @MethodSource("params")
    void checksIfBinaryTreePathsAreCorrect(Param p) {
        System.out.println(p);

        List<String> actualPaths = binaryTreePaths.binaryTreePaths(p.root);

        assertThat(actualPaths).containsExactlyElementsOf(p.paths);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3)),
                        List.of("1->2->5", "1->3")),
                Param.of(new TreeNode(1), List.of("1"))
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private TreeNode root;
        private List<String> paths;
    }
}