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

        try {
            return Math.abs(subTreeHeight(root.left) - subTreeHeight(root.right)) <= 1;
        } catch (Exception e) {
            return false;
        }
    }

    private int subTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int leftHeight = subTreeHeight(root.left) + 1;
        final int rightHeight = subTreeHeight(root.right) + 1;
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight);
        }
        throw new UnbalancedTreeException();
    }

    private static class UnbalancedTreeException extends RuntimeException {}
}
