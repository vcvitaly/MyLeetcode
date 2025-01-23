package com.github.vcvitaly._437;

import com.github.vcvitaly.common.TreeNode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        final Map<String, Long> sumByPath = new LinkedHashMap<>();
        final Stack<TreeNode> stack = new Stack<>();
        sumByPath.put("", (long) root.val);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null) {
                stack.push(node.left);
            } else if (node.right != null) {
                stack.push(node.right);
            } else {
                node = stack.pop();

            }
        }
    }

    private static class Direction {
        private static final String LEFT = "L";
        private static final String RIGHT = "R";
    }
}
