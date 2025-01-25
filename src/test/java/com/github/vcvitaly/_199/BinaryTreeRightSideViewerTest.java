package com.github.vcvitaly._199;

import com.github.vcvitaly.common.TreeNode;
import com.github.vcvitaly.util.TreeUtil;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeRightSideViewerTest {

    private final BinaryTreeRightSideViewer viewer = new BinaryTreeRightSideViewer();

    @Test
    void test1() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{1,2,3,null,5,null,4});
        assertThat(viewer.rightSideView(root)).isEqualTo(List.of(1,3,4));
    }

    @Test
    void test2() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{1,2,3,4,null,null,null,5});
        assertThat(viewer.rightSideView(root)).isEqualTo(List.of(1,3,4,5));
    }

    @Test
    void test3() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{1,null,3});
        assertThat(viewer.rightSideView(root)).isEqualTo(List.of(1,3));
    }

    @Test
    void test4() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{});
        assertThat(viewer.rightSideView(root)).isEqualTo(List.of());
    }
}