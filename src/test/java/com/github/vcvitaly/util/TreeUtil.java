package com.github.vcvitaly.util;

import com.github.vcvitaly.common.TreeNode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TreeUtil {

    public static TreeNode buildTreeNode(Integer[] arrRepresentation) {
        return buildTreeNode(
                Arrays.stream(arrRepresentation).toList()
        );
    }

    public static TreeNode buildTreeNode(List<Integer> arrRepresentation) {
        final TreeNode[] treeNodes = new TreeNode[arrRepresentation.size()];
        for (int i = 0; i < arrRepresentation.size(); i++) {
            final Integer value = arrRepresentation.get(i);
            if (value != null) {
                final TreeNode node = Optional.ofNullable(treeNodes[i])
                        .orElseGet(() -> new TreeNode(value));
                if (leftChildIndex(i) < arrRepresentation.size()) {
                    final Integer leftValue = arrRepresentation.get(leftChildIndex(i));
                    if (leftValue != null) {
                        final TreeNode nodeLeft = new TreeNode(leftValue);
                        node.left = nodeLeft;
                        treeNodes[leftChildIndex(i)] = nodeLeft;
                    }
                }
                if (rightChildIndex(i) < arrRepresentation.size()) {
                    final Integer rightValue = arrRepresentation.get(rightChildIndex(i));
                    if (rightValue != null) {
                        final TreeNode nodeRight = new TreeNode(rightValue);
                        node.right = nodeRight;
                        treeNodes[rightChildIndex(i)] = nodeRight;
                    }
                }
                treeNodes[i] = node;
            }
        }
        return treeNodes[0];
    }

    private static int leftChildIndex(int i) {
        return i * 2 + 1;
    }

    private static int rightChildIndex(int i) {
        return i * 2 + 2;
    }
}
