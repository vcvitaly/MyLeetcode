package com.github.vcvitaly._872;

import com.github.vcvitaly.common.TreeNode;
import com.github.vcvitaly.util.TreeUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeafSimilarityDeterminatorTest {

    private final LeafSimilarityDeterminator determinator = new LeafSimilarityDeterminator();

    @Test
    void test1() {
        final Integer[] root1Arr = new Integer[]{3,5,1,6,2,9,8,null,null,7,4};
        final Integer[] root2Arr = new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        final TreeNode root1 = TreeUtil.buildTreeNode(root1Arr);
        final TreeNode root2 = TreeUtil.buildTreeNode(root2Arr);
        assertThat(determinator.leafSimilar(root1, root2)).isTrue();
    }

    @Test
    void test2() {
        final Integer[] root1Arr = new Integer[]{1,2,3};
        final Integer[] root2Arr = new Integer[]{1,3,2};
        final TreeNode root1 = TreeUtil.buildTreeNode(root1Arr);
        final TreeNode root2 = TreeUtil.buildTreeNode(root2Arr);
        assertThat(determinator.leafSimilar(root1, root2)).isFalse();
    }
}