package com.github.vcvitaly._222;

import com.github.vcvitaly.common.TreeNode;

// WIP
public class CompleteTreeNodeCounter {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return 0;
    }
}
