package com.github.vcvitaly._2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class AddTwoNumbersTest {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    private Object[] getParams() {
        return $(
                $("342", "465", "807"),
                $("999", "1", "1000")
        );
    }

    @Test
    @Parameters(method = "getParams")
    public void addTwoNumbers(String number1, String number2, String result) {
        ListNode inputNode1 = addTwoNumbers.getListNodeFromString(number1);
        ListNode inputNode2 = addTwoNumbers.getListNodeFromString(number2);
        ListNode outputNode = addTwoNumbers.getListNodeFromString(result);

        assertEquals(outputNode.toNumber(), addTwoNumbers.addTwoNumbers(inputNode1, inputNode2).toNumber());

    }
}