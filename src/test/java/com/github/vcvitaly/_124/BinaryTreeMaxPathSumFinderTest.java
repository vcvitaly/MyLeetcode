package com.github.vcvitaly._124;

import com.github.vcvitaly.common.TreeNode;
import com.github.vcvitaly.util.TreeUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaxPathSumFinderTest {

    private final BinaryTreeMaxPathSumFinder finder = new BinaryTreeMaxPathSumFinder();

    @Test
    void test1() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{1, 2, 3});
        assertThat(finder.maxPathSum(root)).isEqualTo(6);
    }

    @Test
    void test2() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{-10,9,20,null,null,15,7});
        assertThat(finder.maxPathSum(root)).isEqualTo(42);
    }

    @Test
    void test3() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{-2,-1});
        assertThat(finder.maxPathSum(root)).isEqualTo(-1);
    }

    @Test
    void test4() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{2,-1});
        assertThat(finder.maxPathSum(root)).isEqualTo(2);
    }

    @Test
    void test5() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{-1,5,null,4,null,null,2,-4});
        assertThat(finder.maxPathSum(root)).isEqualTo(11);
    }
}