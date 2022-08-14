package com.github.vcvitaly._26;

/**
 * RemoveDuplicatesFromSortedArray.
 *
 * @author Vitalii Chura
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicatesSlow(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k ; j++) {
                if (nums[i] == nums[j]) {
                    // shifting to left by one position
                    for (int l = j + 1; l < k; l++) {
                        nums[l-1] = nums[l];
                    }
                    nums[k-1] = -1;
                    k--;
                    j--; // because all elements were shifted to left, if we do not do that we might skip an element
                }
            }
        }
        return k;
    }

    /*
    This solution is not mine
    public int removeDuplicates(int[] nums) {

        int count=1;

        for(int i=1, j=0; i < nums.length; i++){
            if(nums[j] != nums[i]){
                count++;
                nums[++j] = nums[i];

            }
        }
        return count;
    }*/
}
