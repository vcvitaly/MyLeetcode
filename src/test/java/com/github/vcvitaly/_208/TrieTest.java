package com.github.vcvitaly._208;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    private final Trie trie = new Trie();

    @Test
    void test1() {
        trie.insert("apple");
        assertThat(trie.search("apple")).isTrue();
        assertThat(trie.search("app")).isFalse();
        assertThat(trie.startsWith("app")).isTrue();
        trie.insert("app");
        assertThat(trie.search("app")).isTrue();
    }
}