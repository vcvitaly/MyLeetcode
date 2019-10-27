package com.github.vcvitaly._268;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingNumberTest {
    MissingNumber missingNumber = new MissingNumber();

    @Test
    public void findsMissingNumber() {
        assertThat(missingNumber.missingNumber(new int[] {3,0,1})).isEqualTo(2);
        assertThat(missingNumber.missingNumber(new int[] {9,6,4,2,3,5,7,0,1})).isEqualTo(8);
    }
}