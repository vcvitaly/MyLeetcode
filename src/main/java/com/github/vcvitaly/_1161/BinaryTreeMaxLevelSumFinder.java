package com.github.vcvitaly._1161;

import com.github.vcvitaly.common.TreeNode;

public class BinaryTreeMaxLevelSumFinder {

    public int maxLevelSum(TreeNode root) {
        return 0;
    }

    private static class TreeNodeWrapper {
        private TreeNode treeNode;
        private int level;

        public TreeNodeWrapper(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}
