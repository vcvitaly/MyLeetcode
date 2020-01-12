package com.github.vcvitaly._28;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LongestCommonPrefixFinderTest {

    private LongestCommonPrefixFinder longestCommonPrefixFinder = new LongestCommonPrefixFinder();

    private Object[] getParams() {
        return $(
                $(new String[] {"flower", "flow", "flight"}, "fl"),
                $(new String[] {"dog","racecar","car"}, "")
        );
    }

    @Test
    @Parameters(method = "getParams")
    public void findsLongestCommonPrefix(String[] words, String longestCommonPrefix) {
        assertThat(longestCommonPrefixFinder.longestCommonPrefix(words)).isEqualTo(longestCommonPrefix);
    }
}