package com.github.vcvitaly._590;

import com.github.vcvitaly.common.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NTreePostorderTraversal.
 *
 * @author Vitalii Chura
 */
public class NTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        for (Node child : root.children) {
            values.addAll(postorder(child));
        }
        values.add(root.val);
        return values;
    }
}
