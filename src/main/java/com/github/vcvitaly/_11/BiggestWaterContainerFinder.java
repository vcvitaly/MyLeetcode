package com.github.vcvitaly._11;

public class BiggestWaterContainerFinder {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = area(height, left, right);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            final int area = area(height, left, right);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int area(int[] height, int left, int right) {
        final int minHeight = Math.min(height[left], height[right]);
        return minHeight * (right - left);
    }
}
