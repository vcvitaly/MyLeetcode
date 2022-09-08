package com.github.vcvitaly._589;

import com.github.vcvitaly.common.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NTreePreorderTraversal.
 *
 * @author Vitalii Chura
 */
public class NTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        for (Node child : root.children) {
            values.addAll(preorder(child));
        }
        return values;
    }
}
