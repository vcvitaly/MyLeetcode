package com.github.vcvitaly._93;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IpAddressDecoderTest {

    private final IpAddressDecoder decoder = new IpAddressDecoder();

    @Test
    void test1() {
        assertThat(decoder.restoreIpAddresses("25525511135"))
                .containsExactlyInAnyOrderElementsOf(List.of("255.255.11.135", "255.255.111.35"));
    }

    @Test
    void test2() {
        assertThat(decoder.restoreIpAddresses("0000"))
                .containsExactlyInAnyOrderElementsOf(List.of("0.0.0.0"));
    }

    @Test
    void test3() {
        assertThat(decoder.restoreIpAddresses("101023"))
                .containsExactlyInAnyOrderElementsOf(List.of("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"));
    }

    @Test
    void test4() {
        assertThat(decoder.restoreIpAddresses("172162541"))
                .containsExactlyInAnyOrderElementsOf(List.of("17.216.25.41","17.216.254.1","172.16.25.41","172.16.254.1","172.162.5.41","172.162.54.1"));
    }
}