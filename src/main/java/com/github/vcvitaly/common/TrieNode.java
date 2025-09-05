package com.github.vcvitaly.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public record TrieNode(Character value, Map<Character, TrieNode> edges) {

    public TrieNode(Character value) {
        this(value, new HashMap<>());
    }

    public boolean hasKey(Character key) {
        return edges.containsKey(key);
    }

    public TrieNode getChild(Character key) {
        return edges.get(key);
    }

    public void addChild(Character key, TrieNode child) {
        edges.put(key, child);
    }

    @Override
    public String toString() {
        return "TrieNode{value=%s, edges=%s}".formatted(value, edges.keySet());
    }
}
