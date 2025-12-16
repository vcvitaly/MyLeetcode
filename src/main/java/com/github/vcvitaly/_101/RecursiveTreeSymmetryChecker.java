package com.github.vcvitaly._101;

import com.github.vcvitaly.common.TreeNode;

public class RecursiveTreeSymmetryChecker {

    public boolean isSymmetric(TreeNode root) {
        return equal(root.left, root.right);
    }

    private boolean equal(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return equal(left.left, right.right) && equal(left.right, right.left);
        }
        return false;
    }
}
