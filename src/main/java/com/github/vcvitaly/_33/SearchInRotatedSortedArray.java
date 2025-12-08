package com.github.vcvitaly._33;

/**
 * SearchInRotatedSortedArray.
 *
 * @author Vitalii Chura
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length <= 2) {
            if (nums[0] == target) {
                return 0;
            }
            return nums.length == 2 && nums[1] == target ? 1 : -1;
        }

        int k = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int leftIndex = leftIndex(nums, mid);
            if (nums[leftIndex] > nums[mid]) {
                k = mid;
                break;
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        boolean targetBeforePivot = target <= nums[leftIndex(nums, k)];
        if (target >= nums[k] && targetBeforePivot) {
            if (target >= nums[0] && targetBeforePivot) {
                left = 0;
                right = leftIndex(nums, k);
            } else {
                left = k;
                right = nums.length - 1;
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (target == nums[mid]) {
                    return mid;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return nums[left] == target ? left : -1;
        }

        return -1;
    }

    private int rightIndex(int[] nums, int i) {
        if (i < nums.length - 1) {
            return i + 1;
        }
        return 0;
    }

    private int leftIndex(int[] nums, int i) {
        if (i == 0) {
            return nums.length - 1;
        }
        return i - 1;
    }
}
