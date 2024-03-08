package com.github.vcvitaly._110;

import com.github.vcvitaly.common.TreeNode;

/**
 * BalancedBinaryTree.
 *
 * @author Vitalii Chura
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(subTreeHeight(root.left) - subTreeHeight(root.right)) <= 1;
    }

    private int subTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(subTreeHeight(root.left) + 1, subTreeHeight(root.right) + 1);
    }
}
