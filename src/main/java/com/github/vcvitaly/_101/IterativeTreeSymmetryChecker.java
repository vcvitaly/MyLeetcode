package com.github.vcvitaly._101;

import com.github.vcvitaly.common.TreeNode;

// WIP
public class IterativeTreeSymmetryChecker {

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return false;
    }
}
