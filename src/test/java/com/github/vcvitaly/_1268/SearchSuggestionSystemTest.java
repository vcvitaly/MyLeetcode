package com.github.vcvitaly._1268;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchSuggestionSystemTest {

    private final SearchSuggestionSystem suggestionSystem = new SearchSuggestionSystem();

    @Test
    void test1() {
        final String[] products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
        assertThat(suggestionSystem.suggestedProducts(products, "mouse"))
                .containsExactlyElementsOf(List.of(
                        List.of("mobile", "moneypot", "monitor"),
                        List.of("mobile", "moneypot", "monitor"),
                        List.of("mouse", "mousepad"),
                        List.of("mouse", "mousepad"),
                        List.of("mouse", "mousepad")
                ));
    }

    @Test
    void test2() {
        final String[] products = new String[] {"havana"};
        assertThat(suggestionSystem.suggestedProducts(products, "havana"))
                .containsExactlyElementsOf(List.of(
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana")
                ));
    }
}