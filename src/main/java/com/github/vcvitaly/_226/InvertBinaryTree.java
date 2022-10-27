package com.github.vcvitaly._226;

import com.github.vcvitaly.common.TreeNode;

/**
 * InvertBinaryTree.
 *
 * @author Vitalii Chura
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}
