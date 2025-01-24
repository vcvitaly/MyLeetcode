package com.github.vcvitaly._872;

import com.github.vcvitaly.common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarityDeterminator {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        final List<Integer> seq1 = getLeafSeq(root1);
        final List<Integer> seq2 = getLeafSeq(root2);
        return seq1.equals(seq2);
    }

    private List<Integer> getLeafSeq(TreeNode root) {
        final List<Integer> seq = new ArrayList<>();
        final Stack<TreeNodeWrapper> stack = new Stack<>();
        stack.push(new TreeNodeWrapper(root));
        while (!stack.isEmpty()) {
            final TreeNodeWrapper node = stack.peek();
            if (!node.leftVisited && node.treeNode.left != null) {
                node.leftVisited = true;
                stack.push(new TreeNodeWrapper(node.treeNode.left));
            } else if (!node.rightVisited && node.treeNode.right != null) {
                node.rightVisited = true;
                stack.push(new TreeNodeWrapper(node.treeNode.right));
            } else {
                if (node.treeNode.left == null && node.treeNode.right == null) {
                    seq.add(node.treeNode.val);
                }
                stack.pop();
            }
        }
        return seq;
    }

    private static class TreeNodeWrapper {
        private boolean leftVisited;
        private boolean rightVisited;
        private TreeNode treeNode;

        private TreeNodeWrapper(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }
}
