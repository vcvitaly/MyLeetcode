package com.github.vcvitaly._212;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardWordSearcherTest {

    private final BoardWordSearcher boardWordSearcher = new BoardWordSearcher();

    @Test
    void test1() {
        final char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        final String[] words = {"oath","pea","eat","rain"};
        assertThat(boardWordSearcher.findWords(board, words)).containsExactlyInAnyOrder(words);
    }

    @Test
    void test2() {
        final char[][] board = {{'a','b'},{'c','d'}};
        final String[] words = {"abcb"};
        assertThat(boardWordSearcher.findWords(board, words)).isEmpty();
    }
}