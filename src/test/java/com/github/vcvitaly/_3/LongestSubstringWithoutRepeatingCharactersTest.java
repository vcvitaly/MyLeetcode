package com.github.vcvitaly._3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

    private Object[] getParams() {
        return $(
                $("abcabcbb", 3),
                $("bbbbb", 1),
                $("pwwkew", 3),
                $("abcdefgha", 8),
                $(" ", 1),
                $("dvdf", 3)
        );
    }

    @Test
    @Parameters(method = "getParams")
    public void lengthOfLongestSubstring(String s, int longestSubstring) {
        assertEquals(longestSubstring, solution.lengthOfLongestSubstring(s));
    }
}