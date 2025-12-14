package com.github.vcvitaly._108;

import com.github.vcvitaly.common.TreeNode;

public class SortedArrayToBSTConverter {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTInternal(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTInternal(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex == leftIndex) {
            return new TreeNode(nums[leftIndex]);
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex], null, new TreeNode(nums[rightIndex]));
        }

        int middle = (rightIndex - leftIndex) / 2 + leftIndex;
        TreeNode subRoot = new TreeNode(nums[middle]);
        subRoot.left = sortedArrayToBSTInternal(nums, leftIndex, middle - 1);
        subRoot.right = sortedArrayToBSTInternal(nums, middle + 1, rightIndex);
        return subRoot;
    }
}
