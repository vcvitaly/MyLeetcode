package com.github.vcvitaly._1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    private Object[] getParamsForTwoSum() {
        return $(
                $(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                $(new int[] {2, 7, 11, 15}, 22, new int[] {1, 3})
        );
    }

    @Test
    @Parameters(method = "getParamsForTwoSum")
    public void twoSum(int[] nums, int target, int[] expectedOutput) {
        int[] output = twoSum.twoSum(nums, target);
        assertThat(output).containsExactly(expectedOutput);
    }
}