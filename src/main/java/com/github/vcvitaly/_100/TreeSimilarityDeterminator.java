package com.github.vcvitaly._100;

import com.github.vcvitaly.common.TreeNode;

import java.util.Objects;

public class TreeSimilarityDeterminator {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }

        return hash(p) == hash(q);
    }

    private int hash(TreeNode node) {
        if (node == null) {
            return Objects.hashCode(null);
        }
        return Objects.hash(node.val, hash(node.left), hash(node.right));
    }
}
