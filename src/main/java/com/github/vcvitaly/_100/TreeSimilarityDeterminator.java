package com.github.vcvitaly._100;

import com.github.vcvitaly.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSimilarityDeterminator {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        final Queue<TreeNode> pQ = new LinkedList<>(List.of(p));
        final Queue<TreeNode> qQ = new LinkedList<>(List.of(q));

        while (!pQ.isEmpty() && !qQ.isEmpty()) {
            TreeNode pNode = pQ.poll();
            TreeNode qNode = qQ.poll();
            if (pNode.val != qNode.val || (pNode.left != null && qNode.left == null) || (pNode.right != null && qNode.right == null)) {
                return false;
            }
            if (pNode.left != null) {
                pQ.add(pNode.left);
            }
            if (qNode.left != null) {
                qQ.add(qNode.left);
            }
            if (pNode.right != null) {
                pQ.add(pNode.right);
            }
            if (qNode.right != null) {
                qQ.add(qNode.right);
            }
        }

        return pQ.isEmpty() && qQ.isEmpty();
    }
}
