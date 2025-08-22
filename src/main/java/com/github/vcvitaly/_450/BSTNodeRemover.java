package com.github.vcvitaly._450;

import com.github.vcvitaly.common.TreeNode;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Consumer;

public class BSTNodeRemover {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return null;
        }

        final Stack<TreeNodeWrapper> stack = new Stack<>();
        stack.push(new TreeNodeWrapper(root));
        while (!stack.isEmpty()) {
            final TreeNodeWrapper node = stack.peek();
            if (node.val() == key) {
                stack.pop();
                final TreeNodeWrapper parent = stack.pop();
                final Consumer<TreeNodeWrapper> parentLinker;
                if (node.val() == parent.left().val()) {
                    parentLinker = nodeWrapper -> parent.node.left = nodeWrapper.node.right;
                } else {
                    parentLinker = nodeWrapper -> parent.node.right = nodeWrapper.node.left;
                }
                if (node.left().isNullNode() && node.right().isNullNode()) {
                    parentLinker.accept(null);
                    return root;
                }
                if (node.left().isNullNode()) {
                    parentLinker.accept(node.right());
                    return root;
                }
                if (node.right().isNullNode()) {
                    parentLinker.accept(node.right());
                    return root;
                }
                parentLinker.accept(node.left());
                Optional<TreeNodeWrapper> promotedNode = Optional.ofNullable(node.left().right());
                Optional<TreeNodeWrapper> parentNode = Optional.of(parent.left());
                while (promotedNode.isPresent()) {
                    promotedNode = promotedNode.map(node1 -> null);
                }

            }
            if (!node.leftVisited && !node.left().isNullNode()) {
                stack.push(node.left());
                node.leftVisited = true;
            } else if (!node.rightVisited && !node.right().isNullNode()) {
                stack.push(node.right());
                node.rightVisited = true;
            } else {
                stack.pop();
            }
        }

        return root;
    }

    private static class TreeNodeWrapper {
        private boolean leftVisited;
        private boolean rightVisited;
        private TreeNode node;

        public TreeNodeWrapper(TreeNode node) {
            this.node = node;
        }

        public TreeNodeWrapper left() {
            return new TreeNodeWrapper(node.left);
        }

        public TreeNodeWrapper right() {
            return new TreeNodeWrapper(node.right);
        }

        public int val() {
            return node.val;
        }

        public boolean isNullNode() {
            return node == null;
        }
    }
}
