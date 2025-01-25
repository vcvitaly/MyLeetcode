package com.github.vcvitaly._236;

import com.github.vcvitaly.common.TreeNode;
import com.github.vcvitaly.util.TreeUtil;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorFinderTest {

    private final LowestCommonAncestorFinder finder = new LowestCommonAncestorFinder();

    @Test
    void test1() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        assertThat(finder.lowestCommonAncestor(root, root.left, root.right)).isEqualTo(root);
    }

    @Test
    void test2() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        assertThat(finder.lowestCommonAncestor(root, root.left, root.left.right.right)).isEqualTo(root.left);
    }

    @Test
    void test3() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{1,2});
        assertThat(finder.lowestCommonAncestor(root, root, root.left)).isEqualTo(root);
    }

    @Test
    void testPerf() {
        final int size = 100;
        final Integer[] a = new Integer[size];
        a[0]= -1;
        final Queue<Integer> queue = IntStream
                .range(0, 9_999).boxed().collect(Collectors.toCollection(LinkedList::new));
        for (int i = 1; i < size; i++) {
            if (i % 2 == 1) {
                a[i] = queue.poll();
            } else {
                a[i] = null;
            }
        }
        final TreeNode root = TreeUtil.buildTreeNode(a);
        final TreeNode p = new TreeNode(9998, null, null);
        final TreeNode q = new TreeNode(9999);
        assertThat(finder.lowestCommonAncestor(root, p, q)).isNull();
    }
}