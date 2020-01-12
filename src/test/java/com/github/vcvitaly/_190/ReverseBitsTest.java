package com.github.vcvitaly._190;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ReverseBitsTest {

    ReverseBits reverseBits = new ReverseBits();

    @Test
    public void reversesBits() {
        assertThat(reverseBits.reverseBits(43261596)).isEqualTo(964176192);
        assertThat(reverseBits.reverseBits(-3)).isEqualTo(-1073741825);
    }
}