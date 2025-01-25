package com.github.vcvitaly._199;

import com.github.vcvitaly.common.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class BinaryTreeRightSideViewer {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        if (root.left == null && root.right == null) {
            return List.of(root.val);
        }

        final List<Integer> view = new LinkedList<>();
        final Queue<TreeNodeWrapper> q = new LinkedList<>();
        q.add(new TreeNodeWrapper(root, 0));
        while (!q.isEmpty()) {
            final TreeNodeWrapper node = q.poll();
            node.leftChild().ifPresent(q::add);
            node.rightChild().ifPresent(q::add);
            if (q.peek() == null || q.peek().height > node.height) {
                view.add(node.node.val);
            }
        }
        return view;
    }

    private record TreeNodeWrapper(TreeNode node, int height) {

        public Optional<TreeNodeWrapper> leftChild() {
            return getChild(node.left);
        }

        public Optional<TreeNodeWrapper> rightChild() {
            return getChild(node.right);
        }

        private Optional<TreeNodeWrapper> getChild(TreeNode node) {
            return Optional.ofNullable(node).map(tr -> new TreeNodeWrapper(tr, height + 1));
        }
    }
}
