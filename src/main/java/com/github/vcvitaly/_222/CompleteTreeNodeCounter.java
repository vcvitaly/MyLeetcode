package com.github.vcvitaly._222;

import com.github.vcvitaly.common.TreeNode;

public class CompleteTreeNodeCounter {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int height = 0;
        TreeNode cur = root;
        while (cur != null) {
            height++;
            cur = cur.left;
        }

        return countNodes(root, height - 1, 1);
    }

    private int countNodes(TreeNode root, int targetHeight, int height) {
        if (height == targetHeight) {
            return 1 + (root.left == null ? 0 : 1) + (root.right == null ? 0 : 1);
        }
        return 1 + countNodes(root.left, targetHeight, height + 1) + countNodes(root.right, targetHeight, height + 1);
    }
}
