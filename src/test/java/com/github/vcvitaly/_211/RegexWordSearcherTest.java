package com.github.vcvitaly._211;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegexWordSearcherTest {

    private final RegexWordSearcher searcher = new RegexWordSearcher();

    @Test
    void test1() {
        searcher.addWord("bad");
        searcher.addWord("dad");
        searcher.addWord("mad");
        assertThat(searcher.search("pad")).isFalse();
        assertThat(searcher.search("bad")).isTrue();
        assertThat(searcher.search(".ad")).isTrue();
        assertThat(searcher.search("b..")).isTrue();
    }
}