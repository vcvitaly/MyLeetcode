package com.github.vcvitaly._33;

/**
 * SearchInRotatedSortedArray.
 *
 * @author Vitalii Chura
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            }
            return nums[1] == target ? 1 : -1;
        }

        int k = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[leftIndex(nums, mid)] > nums[mid]) {
                k = mid;
                break;
            }
            int rightIndex = rightIndex(nums, mid);
            if (nums[rightIndex] < nums[mid]) {
                k = rightIndex;
                break;
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (target == nums[k]) {
            return k;
        }

        boolean targetBeforePivot = target <= nums[leftIndex(nums, k)];
        boolean targetAfterPivot = target > nums[k];
        if (targetAfterPivot || targetBeforePivot) {
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
