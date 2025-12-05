package com.github.vcvitaly._22;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParenthesisGeneratorTest {

    private final ParenthesisGenerator generator = new ParenthesisGenerator();

    @Test
    void test1() {
        assertThat(generator.generateParenthesis(1))
                .isEqualTo(List.of("()"));
    }

    @Test
    void test2() {
        assertThat(generator.generateParenthesis(2))
                .isEqualTo(List.of("(())","()()"));
    }

    @Test
    void test3() {
        assertThat(generator.generateParenthesis(3))
                .isEqualTo(List.of("((()))","(()())","(())()","()(())","()()()"));
    }
}