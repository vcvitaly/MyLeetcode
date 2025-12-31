package com.github.vcvitaly._124;

import com.github.vcvitaly.common.TreeNode;

import java.util.stream.Stream;

// WIP
public class BinaryTreeMaxPathSumFinder {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return root.val;
        }

        return findSumPair(root).bestPathSum;
    }

    private Result findSumPair(TreeNode root) {
        if (root == null) {
            return Result.ofSingleNode(null);
        }

        if (isLeaf(root)) {
            return Result.ofSingleNode(root);
        }

        final Result leftResult = findSumPair(root.left);
        final Result rightResult = findSumPair(root.right);

        final SubPath newSubPath = leftResult.bestSubPath.sum >= rightResult.bestSubPath.sum ?
                join(leftResult.bestSubPath, root) : join(rightResult.bestSubPath, root);

        if (equals(leftResult.bestSubPath.subRoot, root.left) && equals(rightResult.bestSubPath.subRoot, root.right)) {
            return new Result(
                    newSubPath,
                    Stream.of(
                            newSubPath.sum,
                            leftResult.bestSubPath.sum + rightResult.bestSubPath.sum + root.val,
                            leftResult.bestPathSum,
                            rightResult.bestPathSum,
                            root.val
                    ).max(Integer::compareTo).orElseThrow()
            );
        }

        final int newBestPathSum = Math.max(newSubPath.sum, Math.max(leftResult.bestPathSum, rightResult.bestPathSum));
        return new Result(newSubPath, newBestPathSum);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private boolean equals(TreeNode root1, TreeNode root2) {
        return System.identityHashCode(root1) == System.identityHashCode(root2);
    }

    private SubPath join(SubPath subPath, TreeNode root) {
        return new SubPath(subPath.sum + root.val, root);
    }

    private record SubPath(int sum, TreeNode subRoot) {}

    private record Result(SubPath bestSubPath, int bestPathSum) {

        private static Result ofSingleNode(TreeNode root) {
            int val = root == null ? Integer.MIN_VALUE / 10 : root.val;
            return new Result(
                    new SubPath(val, root),
                    val
            );
        }
    }

    /*if (equals(leftResult.bestSubPath.subRoot, root.left) && equals(rightResult.bestSubPath.subRoot, root.right)) {
        return null;
    } else if (equals(leftResult.bestSubPath.subRoot, root.left)) {
        final SubPath newSubPath = new SubPath(leftResult.bestSubPath.sum + root.val, root);
        return new Result(newSubPath, newSubPath.sum > leftResult.bestPathSum ? newSubPath.sum : leftResult.bestPathSum);
    } else if (equals(rightResult.bestSubPath.subRoot, root.right)) {
        return null;
    } else {
        throw new IllegalStateException("At val " + root.val);
    }
    return new Result(null, Math.max(leftResult.bestPathSum, rightResult.bestPathSum));*/
}
