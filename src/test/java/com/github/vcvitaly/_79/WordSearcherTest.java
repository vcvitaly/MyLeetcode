package com.github.vcvitaly._79;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordSearcherTest {

    private final WordSearcher wordSearcher = new WordSearcher();

    @Test
    void test1() {
        assertThat(wordSearcher.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")).isTrue();
    }

    @Test
    void test2() {
        assertThat(wordSearcher.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE")).isTrue();
    }

    @Test
    void test3() {
        assertThat(wordSearcher.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB")).isFalse();
    }
}