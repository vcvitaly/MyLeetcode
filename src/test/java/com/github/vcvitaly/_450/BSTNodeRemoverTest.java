package com.github.vcvitaly._450;

import com.github.vcvitaly.util.TreeUtil;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BSTNodeRemoverTest {

    private final BSTNodeRemover remover = new BSTNodeRemover();

    @Test
    void test1() {
        assertThat(List.of(
                TreeUtil.buildTreeNode(new Integer[]{5, 4, 6, 2, null, null, 7}),
                TreeUtil.buildTreeNode(new Integer[]{5, 2, 6, null, 4, null, 7})
        )).contains(
                remover.deleteNode(
                        TreeUtil.buildTreeNode(new Integer[]{5,3,6,2,4,null,7}), 3
                )
        );
    }

    @Test
    void test2() {
        assertThat(List.of(
                TreeUtil.buildTreeNode(new Integer[]{5,3,6,2,4,null,7})
        )).contains(
                remover.deleteNode(
                        TreeUtil.buildTreeNode(new Integer[]{5,3,6,2,4,null,7}), 0
                )
        );
    }

    @Test
    void test3() {
        assertThat(remover.deleteNode(null, 0)).isNull();
    }
}