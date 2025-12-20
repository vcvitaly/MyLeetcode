package com.github.vcvitaly._71;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class PathSimplifierTest {

    private final PathSimplifier simplifier = new PathSimplifier();

    @Test
    void test1() {
        assertThat(simplifier.simplifyPath("/a/b/c")).isEqualTo("/a/b/c");
    }

    @Test
    void test2() {
        assertThat(simplifier.simplifyPath("/home/")).isEqualTo("/home");
    }

    @Test
    void test3() {
        assertThat(simplifier.simplifyPath("/home//foo/")).isEqualTo("/home/foo");
    }

    @Test
    void test4() {
        assertThat(simplifier.simplifyPath("/home/user/Documents/../Pictures")).isEqualTo("/home/user/Pictures");
    }

    @Test
    void test5() {
        assertThat(simplifier.simplifyPath("/../")).isEqualTo("/");
    }

    @Test
    void test6() {
        assertThat(simplifier.simplifyPath("/.../a/../b/c/../d/./")).isEqualTo("/.../b/d");
    }

    @Test
    void test7() {
        assertThat(simplifier.simplifyPath("/a/b/../b/../b/")).isEqualTo("/a/b");
    }

    @Test
    void test8() {
        assertThat(simplifier.simplifyPath("///")).isEqualTo("/");
    }

    @Test
    void test9() {
        final String path = IntStream.range(0, 1000).mapToObj(i -> "/..").collect(Collectors.joining());
        assertThat(simplifier.simplifyPath(path)).isEqualTo("/");
    }
}