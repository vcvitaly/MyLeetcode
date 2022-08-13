package com.github.vcvitaly._26;

/**
 * RemoveDuplicatesFromSortedArray.
 *
 * @author Vitalii Chura
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = 0;
        for (int i = 0; i < nums.length || nums[i] == -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    for (int l = j + 1; l < nums.length; l++) {
                        nums[l-1] = nums[l];
                    }
                }
            }
            k++;
        }
        return k;
    }
}
