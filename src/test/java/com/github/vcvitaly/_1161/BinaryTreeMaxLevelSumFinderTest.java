package com.github.vcvitaly._1161;

import com.github.vcvitaly.common.TreeNode;
import com.github.vcvitaly.util.TreeUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaxLevelSumFinderTest {

    private BinaryTreeMaxLevelSumFinder finder = new BinaryTreeMaxLevelSumFinder();

    @Test
    void test1() {
        final TreeNode root = TreeUtil.buildTreeNode(
                new Integer[]{1,7,0,7,-8,null,null}
        );
        assertThat(finder.maxLevelSum(root)).isEqualTo(2);
    }

    @Test
    void test2() {
        final TreeNode root = TreeUtil.buildTreeNode(
                new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127}
        );
        assertThat(finder.maxLevelSum(root)).isEqualTo(2);
    }

    @Test
    void test3() {
        final TreeNode root = TreeUtil.buildTreeNode(new Integer[]{1});
        assertThat(finder.maxLevelSum(root)).isEqualTo(1);
    }
}