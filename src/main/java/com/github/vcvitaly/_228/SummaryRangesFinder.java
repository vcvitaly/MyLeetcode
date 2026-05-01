package com.github.vcvitaly._228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRangesFinder {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }

        final List<String> res = new ArrayList<>();

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int diff = cur - end;
            if (diff != 0 && diff != 1) {
                res.add(rangeToStr(start, end));
                start = end = cur;
            } else {
                end = cur;
            }
        }

        res.add(rangeToStr(start, end));

        return res;
    }

    private String rangeToStr(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return "%d->%d".formatted(start, end);
    }
}
