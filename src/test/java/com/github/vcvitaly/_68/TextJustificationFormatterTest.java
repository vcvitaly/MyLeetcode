package com.github.vcvitaly._68;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextJustificationFormatterTest {

    private TextJustificationFormatter formatter = new TextJustificationFormatter();

    @Test
    void test1() {
        assertThat(formatter.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16))
                .containsExactly(
                        "This    is    an",
                        "example  of text",
                        "justification.  "
                );
    }

    @Test
    void test2() {
        assertThat(formatter.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16))
                .containsExactly(
                        "What   must   be",
                        "acknowledgment  ",
                        "shall be        "
                );
    }

    @Test
    void test3() {
        assertThat(formatter.fullJustify(new String[]{
                "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.",
                "Art","is","everything","else","we","do"
        }, 20))
                .containsExactly(
                        "Science  is  what we",
                        "understand      well",
                        "enough to explain to",
                        "a  computer.  Art is",
                        "everything  else  we",
                        "do                  "
                );
    }
}