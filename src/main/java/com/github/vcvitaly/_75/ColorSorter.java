package com.github.vcvitaly._75;

public class ColorSorter {

    public void sortColors(int[] nums) {
        final int[] colorCounts = new int[3];
        for (int num : nums) {
            colorCounts[num]++;
        }
        int prevBound = -1;
        for (int i = 0; i < colorCounts.length; i++) {
            if (prevBound == -1) {
                prevBound++;
            }
            int colorCount = colorCounts[i];
            for (int j = prevBound; j < prevBound + colorCount; j++) {
                nums[j] = i;
            }
            prevBound += colorCount;
        }
    }
}
