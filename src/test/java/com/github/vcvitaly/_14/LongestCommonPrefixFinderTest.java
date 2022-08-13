package com.github.vcvitaly._14;

import com.github.vcvitaly._14.LongestCommonPrefixFinder;
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
                $(new String[] {"dog","racecar","car"}, ""),
                $(new String[] {}, ""),
                $(new String[] {"", ""}, ""),
                $(new String[] {"a", "ac"}, "a")
        );
    }

    @Test
    @Parameters(method = "getParams")
    public void findsLongestCommonPrefix(String[] words, String longestCommonPrefix) {
        assertThat(longestCommonPrefixFinder.longestCommonPrefix(words)).isEqualTo(longestCommonPrefix);
    }
}