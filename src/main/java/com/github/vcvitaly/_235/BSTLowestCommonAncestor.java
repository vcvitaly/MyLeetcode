package com.github.vcvitaly._235;

import com.github.vcvitaly.common.TreeNode;

import java.util.Stack;

/**
 * BSTLowestCommonAncestor.
 *
 * @author Vitalii Chura
 */
public class BSTLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        while (root != null) {
            if (p.val <= root.val && q.val >= root.val || p.val >= root.val && q.val <= root.val) {
                return root;
            } else if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}
