package com.github.vcvitaly._102;

import com.github.vcvitaly.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BinaryTreeLevelOrderTraversal.
 *
 * @author Vitalii Chura
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<TreeNode>> levels = new ArrayList<>();
        int currentLevel = 0;
        levels.add(List.of(root));

        while (currentLevel < levels.size()) {
            List<TreeNode> currentLevelNodes = levels.get(currentLevel);
            ArrayList<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode currentLevelNode : currentLevelNodes) {
                if (currentLevelNode.left != null) {
                    nextLevelNodes.add(currentLevelNode.left);
                }
                if (currentLevelNode.right != null) {
                    nextLevelNodes.add(currentLevelNode.right);
                }
            }
            if (!nextLevelNodes.isEmpty()) {
                levels.add(nextLevelNodes);
            }
            currentLevel++;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<TreeNode> currentLevelNodes : levels) {
            List<Integer> values = new ArrayList<>();
            for (TreeNode currentLevelNode : currentLevelNodes) {
                values.add(currentLevelNode.val);
            }
            result.add(values);
        }

        return result;
    }
}
