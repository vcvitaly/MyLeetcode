package com.github.vcvitaly._257;

import com.github.vcvitaly.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BinaryTreePaths.
 *
 * @author Vitalii Chura
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(String.valueOf(root.val));
        }

        return getPaths(root).stream()
                .peek(Collections::reverse)
                .map(pathList -> pathList.stream().map(String::valueOf).collect(Collectors.joining("->")))
                .collect(Collectors.toList());
    }

    private List<List<Integer>> getPaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(new ArrayList<>(List.of(root.val)));
        }

        List<List<Integer>> leftPaths = getPaths(root.left);
        List<List<Integer>> rightPaths = getPaths(root.right);
        for (List<Integer> leftPathList : leftPaths) {
            leftPathList.add(root.val);
        }
        for (List<Integer> rightPathList : rightPaths) {
            rightPathList.add(root.val);
        }
        List<List<Integer>> paths = new ArrayList<>();
        paths.addAll(leftPaths);
        paths.addAll(rightPaths);

        return paths;
    }
}
