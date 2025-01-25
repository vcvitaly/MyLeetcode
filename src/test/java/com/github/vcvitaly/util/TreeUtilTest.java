package com.github.vcvitaly.util;

import com.github.vcvitaly.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeUtilTest {

    @Test
    void test1() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{0});
        assertThat(root).isEqualTo(new TreeNode(0));
    }

    @Test
    void test2() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{0,1,2});
        assertThat(root).isEqualTo(new TreeNode(
                0,
                new TreeNode(1),
                new TreeNode(2)
        ));
    }

    @Test
    void test3() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        assertThat(root).isEqualTo(new TreeNode(
                3,
                new TreeNode(
                        5,
                        new TreeNode(6),
                        new TreeNode(
                                2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),
                new TreeNode(
                        1,
                        new TreeNode(9),
                        new TreeNode(8)
                )
        ));
    }

    @Test
    void test4() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{0,1,null,2,null});
        assertThat(root).isEqualTo(new TreeNode(
                0,
                new TreeNode(1),
                new TreeNode(2)
        ));
    }
}