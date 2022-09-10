package com.github.vcvitaly._1598;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CrawlerLogFolderTest.
 *
 * @author Vitalii Chura
 */
class CrawlerLogFolderTest {

    private CrawlerLogFolder crawlerLogFolder = new CrawlerLogFolder();

    @ParameterizedTest
    @MethodSource("params")
    void minOperationsToReturnToTheMainFolderAreFound(Param p) {
        System.out.println(p);

        int minOperations = crawlerLogFolder.minOperations(p.logs);

        assertThat(minOperations).isEqualTo(p.minOperations);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(new String[] {"d1/","d2/","../","d21/","./"}, 2),
                Param.of(new String[] {"d1/","d2/","./","d3/","../","d31/"}, 3),
                Param.of(new String[] {"d1/","../","../","../"}, 0)
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        private String[] logs;
        private int minOperations;
    }
}