package com.github.vcvitaly._144;

import com.github.vcvitaly.common.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BinaryTreePreorderTraversal.
 *
 * @author Vitalii Chura
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        values.addAll(preorderTraversal(root.left));
        values.addAll(preorderTraversal(root.right));
        return values;
    }
}
