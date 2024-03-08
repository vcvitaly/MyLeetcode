package com.github.vcvitaly._168;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ExcelSheetColumnTitleTest.
 *
 * @author Vitalii Chura
 */
class ExcelSheetColumnTitleTest {

    private ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

    @ParameterizedTest
    @MethodSource("params")
    void convertsANumberToExcelSheetColumnTitle(Param p) {
        System.out.println(p);

        assertThat(excelSheetColumnTitle.convertToTitle(p.i)).isEqualTo(p.excelSheetColumnTitle);
    }

    static Stream<Param> params() {
        return Stream.of(
                Param.of(1, "A"),
                Param.of(28, "AB"),
                Param.of(701, "ZY")
        );
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    private static class Param {
        public int i;
        private String excelSheetColumnTitle;
    }
}