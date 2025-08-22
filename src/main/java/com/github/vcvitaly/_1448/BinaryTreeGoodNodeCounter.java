package com.github.vcvitaly._1448;

import com.github.vcvitaly.common.TreeNode;
import java.util.Stack;
import java.util.function.Function;

public class BinaryTreeGoodNodeCounter {

    public int goodNodes(TreeNode root) {
        final Stack<TreeNodeWrapper> stack = new Stack<>();

        int goodNodesCount = 0;
        stack.push(new TreeNodeWrapper(root.val, root, null));
        while (!stack.isEmpty()) {
            final TreeNodeWrapper wrap = stack.pop();
            if (!wrap.leftVisited) {
                wrap.leftVisited = true;
                stack.push(wrap);
                if (wrap.node.left != null) {
                    stack.push(getLeft(wrap));
                }
            } else if (!wrap.rightVisited) {
                wrap.rightVisited = true;
                stack.push(wrap);
                if (wrap.node.right != null) {
                    stack.push(getRight(wrap));
                }
            } else {
                if (wrap.parent == null || wrap.node.val >= wrap.maxValueOnStack) {
                    goodNodesCount++;
                }
            }
        }

        return goodNodesCount;
    }

    private TreeNodeWrapper getRight(TreeNodeWrapper wrap) {
        return getLeftOrRight(wrap, w -> w.node.right);
    }

    private TreeNodeWrapper getLeft(TreeNodeWrapper wrap) {
        return getLeftOrRight(wrap, w -> w.node.left);
    }

    private TreeNodeWrapper getLeftOrRight(TreeNodeWrapper wrap,
                                           Function<TreeNodeWrapper, TreeNode> childAccessor) {
        return new TreeNodeWrapper(
                Math.max(wrap.maxValueOnStack, wrap.node.val),
                childAccessor.apply(wrap),
                wrap.node
        );
    }

    private static final class TreeNodeWrapper {
        private boolean leftVisited = false;
        private boolean rightVisited = false;
        private final int maxValueOnStack;
        private final TreeNode node;
        private final TreeNode parent;

        public TreeNodeWrapper(int maxValueOnStack, TreeNode node, TreeNode parent) {
            this.maxValueOnStack = maxValueOnStack;
            this.node = node;
            this.parent = parent;
        }
    }
}
