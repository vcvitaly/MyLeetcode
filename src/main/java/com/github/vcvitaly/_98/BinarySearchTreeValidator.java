package com.github.vcvitaly._98;

import com.github.vcvitaly.common.TreeNode;

/**
 * ValidateBinarySearchTree.
 *
 * @author Vitalii Chura
 */
public class BinarySearchTreeValidator {

    private static final Result INVALID_BST_RESULT = new Result(null, null, false);
    private static final Result VALID_BST_RESULT = new Result(null, null, true);

    public boolean isValidBST(TreeNode root) {
        Result result = validateSubtree(root);
        return result.isValidBst;
    }

    public Result validateSubtree(TreeNode root) {
        if (root == null) {
            return VALID_BST_RESULT;
        }
        Result result = new Result();
        result.isValidBst = true;
        Result leftResult = validateSubtree(root.left);
        if (!leftResult.isValidBst || (leftResult.max != null && leftResult.max >= root.val)) {
            return INVALID_BST_RESULT;
        } else {
            result.min = leftResult.min == null ? root.val : leftResult.min;
        }
        Result rightResult = validateSubtree(root.right);
        if (!rightResult.isValidBst || (rightResult.min  != null && rightResult.min <= root.val)) {
            return INVALID_BST_RESULT;
        } else {
            result.max = rightResult.max == null ? root.val : rightResult.max;
        }
        return result;
    }

    private static class Result {
        private Integer min;
        private Integer max;
        private boolean isValidBst;

        Result() {
        }

        Result(Integer min, Integer max, boolean isValidBst) {
            this.min = min;
            this.max = max;
            this.isValidBst = isValidBst;
        }
    }
}
