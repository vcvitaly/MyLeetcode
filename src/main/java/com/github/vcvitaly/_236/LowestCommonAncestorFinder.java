package com.github.vcvitaly._236;

import com.github.vcvitaly.common.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LowestCommonAncestorFinder {

    public static final String ROOT_PATH = "_";

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final Stack<TreeNodeWrapper> stack = new Stack<>();
        final Map<Integer, String> pathByVal = new HashMap<>();
        stack.push(new TreeNodeWrapper(root));
        pathByVal.put(root.val, ROOT_PATH);
        final StringBuilder pathStack = new StringBuilder(ROOT_PATH);
        while (!stack.isEmpty()) {
            TreeNodeWrapper node = stack.peek();
            if ((contains(node.treeNode.left, p, pathByVal, pathStack, Direction.LEFT) &&
                    contains(node.treeNode.right, q, pathByVal, pathStack, Direction.RIGHT)) ||
                    (contains(node.treeNode.left, q, pathByVal, pathStack, Direction.LEFT) &&
                            contains(node.treeNode.right, p, pathByVal, pathStack, Direction.RIGHT))) {
                return node.treeNode;
            }
            if (equals(node.treeNode, p) && contains(node.treeNode, q, pathByVal, pathStack, "")) {
                return node.treeNode;
            }
            if (equals(node.treeNode, q) && contains(node.treeNode, p, pathByVal, pathStack, "")) {
                return node.treeNode;
            }
            if (!node.leftVisited && node.treeNode.left != null) {
                stack.push(new TreeNodeWrapper(node.treeNode.left));
                node.leftVisited = true;
            } else if (!node.rightVisited && node.treeNode.right != null) {
                stack.push(new TreeNodeWrapper(node.treeNode.right));
                node.rightVisited = true;
            } else {
                stack.pop();
            }
        }
        return null;
    }

    private boolean equals(TreeNode a, TreeNode b) {
        return a.val == b.val;
    }

    private boolean contains(TreeNode subTree,
                             TreeNode node,
                             Map<Integer, String> pathByVal,
                             StringBuilder pathStack,
                             String direction
                             ) {
        if (subTree == null) {
            return false;
        }
        pathStack.append(direction);
        pathByVal.put(subTree.val, pathStack.toString());
        if (pathByVal.containsKey(node.val)) {
            return pathByVal.get(node.val).startsWith(pathByVal.get(subTree.val));
        }
        final Stack<TreeNodeWrapper> stack = new Stack<>();
        stack.push(new TreeNodeWrapper(subTree));
        while (!stack.isEmpty()) {
            TreeNodeWrapper cur = stack.peek();
            if (!cur.leftVisited && cur.treeNode.left != null) {
                stack.push(new TreeNodeWrapper(cur.treeNode.left));
                pathStack.append(Direction.LEFT);
                pathByVal.put(cur.treeNode.val, pathStack.toString());
                if (equals(cur.treeNode.left, node)) {
                    return true;
                }
                cur.leftVisited = true;
            } else if (!cur.rightVisited && cur.treeNode.right != null) {
                stack.push(new TreeNodeWrapper(cur.treeNode.right));
                pathStack.append(Direction.RIGHT);
                pathByVal.put(cur.treeNode.val, pathStack.toString());
                if (equals(cur.treeNode.right, node)) {
                    return true;
                }
                cur.rightVisited = true;
            } else {
                stack.pop();
                pathStack.deleteCharAt(pathStack.length() - 1);
            }
        }
        return false;
    }

    private static class TreeNodeWrapper {
        private boolean leftVisited;
        private boolean rightVisited;
        private final TreeNode treeNode;

        private TreeNodeWrapper(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }

    private static class Direction {
        private static final String LEFT = "L";
        private static final String RIGHT = "R";
    }
}
