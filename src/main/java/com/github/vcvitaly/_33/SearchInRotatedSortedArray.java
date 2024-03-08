package com.github.vcvitaly._33;

/**
 * SearchInRotatedSortedArray.
 *
 * @author Vitalii Chura
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int k = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
                mid = (right - left) / 2 + left;
            } else if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
                mid = (right - left) / 2 + left;
            }
        }

        return -1;
    }
}
