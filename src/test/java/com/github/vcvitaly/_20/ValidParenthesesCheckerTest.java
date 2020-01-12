package com.github.vcvitaly._20;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ValidParenthesesCheckerTest {

    private ValidParenthesesChecker validParenthesesChecker = new ValidParenthesesChecker();

    private Object[] getParams() {
        return $(
                $("", true),
                $("()", true),
                $("()[]{}", true),
                $("(]", false),
                $("([)]", false),
                $("{[]}", true),
                $("(", false),
                $("(((", false)
        );
    }

    @Test
    @Parameters(method = "getParams")
    public void checksIfParenthesesAreValid(String s, boolean isValid) {
        assertThat(validParenthesesChecker.isValid(s)).isEqualTo(isValid);
    }
}