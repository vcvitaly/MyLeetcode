package com.github.vcvitaly._168;

/**
 * ExcelSheetColumnTitle.
 *
 * @author Vitalii Chura
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber != 0) {
            sb.append(toCharLetter(columnNumber % 26));
            columnNumber = columnNumber / 26;
        }

        return sb.reverse().toString();
    }

    private char toCharLetter(int intLetter) {
        return (char) (64 + intLetter);
    }
}
