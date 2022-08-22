package com.github.vcvitaly._94;

import com.github.vcvitaly.common.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BSTInOrderTraversal.
 *
 * @author Vitalii Chura
 */
public class BSTInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        values.addAll(inorderTraversal(root.left));
        values.add(root.val);
        values.addAll(inorderTraversal(root.right));
        return values;
    }
}
